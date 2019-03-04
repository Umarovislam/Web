package Connections;

import Configuration.ConfigurationManager;
import Configuration.ConfigurationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc connector
 */
public class JdbcConnector {
   private Connection conn;

    /**
     * get connection to database
     * @return connection to database
     * @throws JDBCConnectionException exception
     * */
    public Connection getConnection() throws JDBCConnectionException {
        ConfigurationManager cfg = ConfigurationManager.getINSTANCE();
        try {
            Class.forName(cfg.getDriverName());
            conn = DriverManager.getConnection(cfg.getURL(), cfg.getLogin(),
                    cfg.getPassword());
        } catch (ClassNotFoundException e) {
            throw new JDBCConnectionException("Can't load database driver.", e);
        } catch (SQLException e) {
            throw new JDBCConnectionException("Can't connect to database.", e);
        }
        if(conn==null) {
            throw new JDBCConnectionException("Driver type is not correct in URL " +
                    cfg.getURL() + ".");
        }
        return conn;
    }

    /**
     * close connection to database
     * @throws JDBCConnectionException exception
     */
   /* public void close() throws JDBCConnectionException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new JDBCConnectionException("Can't close connection", e);
            }
        }
    }*/

}

