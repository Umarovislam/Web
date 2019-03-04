package DAO;

import Connections.JDBCConnectionException;
import Model.Customer;
import Model.Number;
import connectionPool.ConnectionPoolException;
import logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOFree extends DAO{
    final String sql2 = "SELECT * FROM number where free=true ";

    /**
     * constructor for dao
     * @throws DAOException exception
     */
    public DAOFree() throws DAOException{
        super(); }

    public void createFree(Number num) throws DAOException{
    }
    public void deleteFree (int id) throws DAOException {
    }


    public ArrayList<Number> getFreeNum () throws DAOException {
        Number num=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ArrayList<Number> numbers = new ArrayList<>();

        try{
            cn = conPool.retrieve();
            ps = cn.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                numbers.add(new Number(rs.getInt(2),rs.getBoolean(3)));
            /// ////////////////////////
        }
        catch(ConnectionPoolException e)
        {
            MyLogger.log.error("Can't obtain user");
            throw new DAOException("Can't obtain user", e);
        } catch (SQLException e) {
            MyLogger.log.error("Can't perform query");
            throw new DAOException("Can't perform query", e);
        } finally{
                try {
                    cn.close();
                    ps.close();
                    conPool.putback(cn);
                } catch (SQLException e) {
                    MyLogger.log.error("Can't close statement");
                    throw new DAOException("Can't close statement", e);
                }
                catch (ConnectionPoolException e)
                {
                    MyLogger.log.error("Can't close connection");
                    throw new DAOException("Can't close conn", e);
                }
        }
        return numbers;
    }
}
