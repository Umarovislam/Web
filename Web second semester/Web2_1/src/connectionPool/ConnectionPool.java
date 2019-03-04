package connectionPool;

import Configuration.ConfigurationManager;
import Configuration.ConfigurationManager;
import logger.MyLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * class presents connection pool
 */
public class ConnectionPool {
    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();
    ConfigurationManager cfg = ConfigurationManager.getINSTANCE();

    /**
     * constructor for class
     * @param initConnCnt number of connections
     * @throws ConnectionPoolException exception
     */
    public ConnectionPool(int initConnCnt) throws ConnectionPoolException {
        try {
            cfg.initCon();
            Class.forName(cfg.getDriverName());
        } catch (Exception e) {
            MyLogger.log.error("Can't find driver");
            throw new ConnectionPoolException("Can't find driver", e);
        }

        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(getConnection());
        }
    }


    private Connection getConnection() throws ConnectionPoolException {
        Connection conn = null;
        try {
            cfg.initCon();
            conn = DriverManager.getConnection(cfg.getURL(), cfg.getLogin(), cfg.getPassword());
        } catch (Exception e) {
            MyLogger.log.error("Can't get connection");
            throw new ConnectionPoolException("Can't get connection", e);
        }
        return conn;
    }

    /**
     * retrieve connection
     * @return connection
     * @throws ConnectionPoolException exception
     */
    public synchronized Connection retrieve() throws ConnectionPoolException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    /**
     * puts cnnection back to list
     * @param c connection
     * @throws ConnectionPoolException exception
     */
    public synchronized void putback(Connection c) throws ConnectionPoolException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                    throw new ConnectionPoolException("Connection not in the used Conns array");
                }
            }
        }


    /**
     * get amount of available connections
     * @return amount of available connections
     */
    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}