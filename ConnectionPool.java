package ConnectionsManager;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Stack;


public class ConnectionPool{

    private static ConnectionPool instance = null;
    final static int INITIAL_POOL_SIZE = 10;

    private final Stack<Connection> connections;

    public synchronized static ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private ConnectionPool() {
        connections = new Stack<>();
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            try {
                connections.push(DatabaseConnection.createConnection());
            } catch (SQLException e) {
                throw new Error("No Connections");
            }
        }
    }

    public synchronized Connection getConnection() {
        ConnectionInvocationHandler handler = new ConnectionInvocationHandler(connections.pop(), this);
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[]{Connection.class},handler);
    }

    public void releaseConnection(Connection c) {
        connections.push(c);
    }

}


