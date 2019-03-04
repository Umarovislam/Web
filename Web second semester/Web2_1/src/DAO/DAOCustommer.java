package DAO;

import Connections.JDBCConnectionException;
import connectionPool.ConnectionPoolException;
import logger.MyLogger;
import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * dao customer class
 */
public class DAOCustommer extends DAO{
    final String sql1 = "SELECT * FROM customer where id = ?";
    final String sql2 = "SELECT * FROM customer where FirstName = ?";
    final String sql3 = "UPDATE customer SET request = true where = ?";

    /**
     * constructor for dao
     * @throws DAOException dao exception
     */
    public DAOCustommer() throws DAOException{
        super(); }

    /**
     * select books written by specified author
     * @param name name of author
     * @return array list with books
     * @throws DAOException exception
     */
    public ArrayList<Customer> getCustomerbyAuthor(String name) throws DAOException{
        Customer cusutmer=null;
        Connection cn=null;
        PreparedStatement ps=null;
        ArrayList<Customer> cus = new ArrayList<>();

        try{
            cn = conPool.retrieve();
            ps = cn.prepareStatement(sql2);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                cus.add(new Customer(rs.getString(2), rs.getString(3),rs.getBoolean("requset")));
            /// ////////////////////////
        }
        catch(ConnectionPoolException e)
        {
            MyLogger.log.error("Can't obtain books");
            throw new DAOException("Can't obtain books", e);
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
        return cus;
    }

    /**
     * select customer by id
     * @param id
     * @return selected
     * @throws DAOException exception
     */
    public Customer readBook(int id) throws DAOException{
        Customer customer=null;
        Connection cn=null;
        PreparedStatement ps=null;
        try{
            cn = conPool.retrieve();
            ps = cn.prepareStatement(sql1);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                customer = new Customer(rs.getString(2), rs.getString(3), rs.getBoolean(4));

            /// ////////////////////////
        }
        catch(ConnectionPoolException e)
        {
            MyLogger.log.error("Can't obtain user");
            throw new DAOException("Can't obtain user" + id, e);
        } catch (SQLException e) {
            MyLogger.log.error("Can't perform query");
            throw new DAOException("Can't perform query" + id, e);
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
        return customer;
    }

    public void createBook(Customer book) throws DAOException{
    }
    public void deleteBook (int id) throws DAOException {
    }

    /**
     * decrease amount of free books
     * @param id
     * @return updated
     * @throws DAOException exception
     */
    public Customer updateCustomer (int id) throws DAOException {
        Customer customer = (new DAOCustommer()).readBook(id);
        if (!customer.isRequest())
            return null;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conPool.retrieve();
            ps = cn.prepareStatement(sql3);
            ps.setInt(1, id);
            ps.executeUpdate();

            /// ////////////////////////
        } catch (ConnectionPoolException e) {

            MyLogger.log.error("Can't obtain user");
            throw new DAOException("Can't obtain user", e);
        } catch (SQLException e) {
            MyLogger.log.error("Can't perform query");
            throw new DAOException("Can't perform query", e);
        } finally {

            try {
                cn.close();
                ps.close();
                conPool.putback(cn);
            } catch (SQLException e) {
                MyLogger.log.error("Can't close statement");
                throw new DAOException("Can't close statement", e);
            } catch (ConnectionPoolException e) {
                MyLogger.log.error("Can't close connection");
                throw new DAOException("Can't close conn", e);
            }
        }
        return customer;
    }
}
