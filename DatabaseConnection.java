package ConnectionsManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String url = "jdbc:mysql://localhost:3306/users";
    static final String user = "root";
    static final String pass = "admin";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            new Error("fatal error", e);
        }
    }

    protected static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
