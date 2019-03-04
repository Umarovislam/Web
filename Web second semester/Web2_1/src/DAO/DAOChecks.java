package DAO;

import Connections.JDBCConnectionException;
import Model.Check;
import connectionPool.ConnectionPoolException;
import logger.MyLogger;

import java.sql.*;
import java.util.ArrayList;

/**
 * dao Check class
 */
public class DAOChecks extends DAO{
    final String sql1 = "select cs.FirstName, n.no,ch.sum,ch.closed from checks ch join number n on ch.NoId = n.id join customer cs on n.CustomId = cs.id where closed=0";

    /**
     * constructor for dao
     * @throws DAOException
     */
    public DAOChecks() throws DAOException{
        super(); }

    /**
     * @return found
     * @throws DAOException exception
     */
    public ArrayList<Check> NotClosedChecks() throws DAOException{
        ArrayList<Check> uchecks=new ArrayList<>();
        Connection con = null;
        PreparedStatement ps=null;
        try{
            con = conPool.retrieve();
            ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while(rs.next())
                uchecks.add(new Check(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getBoolean(4)));

            /// ////////////////////////
        }
        catch( ConnectionPoolException e)
        {
            MyLogger.log.error("Can't obtain user");
            throw new DAOException("Can't obtain user", e);
        } catch (SQLException e) {
            MyLogger.log.error("Can't perform query");
            throw new DAOException("Can't perform query", e);
        } finally{
            try {
                con.close();
                conPool.putback(con);

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
        return uchecks;
    }

    public void createCheck(Check user) throws DAOException{
    }
    public void deleteCheck (int id) throws DAOException {
    }
    public void updateChek (int id) throws DAOException {
    }
}
