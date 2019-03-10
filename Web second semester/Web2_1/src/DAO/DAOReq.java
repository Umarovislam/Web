package DAO;

import Model.Request;
import connectionPool.ConnectionPoolException;
import logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOReq extends DAO{
    final String sq3 = "SELECT cs.FirstName,r.size,r.days,r.RequestedAt  FROM request r join customer cs on r.CustmerId = cs.id";


    /**
     * access database
     *
     * @throws DAOException
     */
    public DAOReq() throws DAOException {
        super();
    }
    public ArrayList<Request> getRequest() throws DAOException{
        ArrayList<Request> requests=new ArrayList<>();
        Connection con = null;
        PreparedStatement ps=null;
        try{
            con = conPool.retrieve();
            ps = con.prepareStatement(sq3);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                requests.add(new Request(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4)));

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
        return requests;
    }
}
