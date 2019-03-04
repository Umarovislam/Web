package DAO;

import Connections.JDBCConnectionException;
import Connections.JdbcConnector;
import connectionPool.ConnectionPool;

public class DAO {
    protected ConnectionPool conPool;

    /**
     * access database
     * @throws DAOException
     */
    public DAO() throws DAOException
    {
        try
        {
            conPool = new ConnectionPool(5);
        }
        catch (Exception e){
            throw new DAOException("Can't create JdbcConnector ", e);
        }
    }

    /**
     * get connector
     * @return connector
     */
    public ConnectionPool getJdbcConnector() {
        return conPool;
    }
}
