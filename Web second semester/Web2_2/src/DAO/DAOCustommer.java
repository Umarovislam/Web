package DAO;

import Model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * dao customer class
 */
public class DAOCustommer extends DAO{
  //  final String sql1 = "SELECT * FROM customer where id = ?";
  //  final String sql2 = "SELECT * FROM customer where FirstName = ?";
   //  final String sql3 = "UPDATE customer SET request = true where = ?";

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
    public Customer getCustomerbyName(String name) throws DAOException{

        Customer cus = null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Customer> query = manager.createNamedQuery("Customer.customerByName", Customer.class);
        query.setParameter(1, name);
        try {
            transaction = manager.getTransaction();

            transaction.begin();
            cus = query.getSingleResult();

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get user",ex);
        } finally {
            manager.close();
        }
        return cus;
    }

    /**
     * select customer by id
     * @param id
     * @return selected
     * @throws DAOException exception
     */
    public Customer getCustomerById(int id) throws DAOException{
        Customer customer=null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Customer> query = manager.createNamedQuery("Customer.customerById", Customer.class);
        query.setParameter(1, id);
        try {
            transaction = manager.getTransaction();

            transaction.begin();
            customer = query.getSingleResult();

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get user",ex);
        } finally {
            manager.close();
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
        Customer customer = (new DAOCustommer()).getCustomerById(id);
        if (!customer.isRequest())
            return null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        Query query = manager.createQuery("UPDATE Customer customer SET request = true where id= ?1");

        try {
            transaction = manager.getTransaction();

            transaction.begin();
            query.setParameter(1,id);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get book",ex);
        } finally {
            manager.close();
        }
        return customer;
    }
}
