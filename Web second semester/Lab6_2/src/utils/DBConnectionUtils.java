package utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionUtils {
    private static DBConnectionUtils instance;
    private static DataSource ds;

    public static DBConnectionUtils getInstance() {
        if (instance == null) {
            instance = new DBConnectionUtils();
        }
        return instance;
    }

    public DBConnectionUtils() {
        start();
    }

    /**
     * Starts connection pool.
     **/
    public static void start() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("jdbc/__Hotels");
            ds = dataSource;
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Peek connection from pool. The connection must be returned.
     *
     * @return Connection.
     */
    public synchronized Connection acquireConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
