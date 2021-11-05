package ConnectionsManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {
    private final Connection original;

    private ConnectionPool pool;

    ConnectionInvocationHandler(Connection original, ConnectionPool pool) {
        this.original = original;
        this.pool = pool;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if ("close".equals(method.getName())) {
            pool.releaseConnection(original);
            return null;
        }
        return method.invoke(original, args);
    }
}
