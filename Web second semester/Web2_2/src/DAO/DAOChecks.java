package DAO;

import Model.Checks;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * dao Checks class
 */
public class DAOChecks extends DAO{
   // final String sql1 = "select cs.FirstName, n.no,ch.sum,ch.closed from Checkss ch join number n on ch.NoId = n.id join customer cs on n.CustomId = cs.id where closed=0";

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
    public List<Checks> NotClosedChecks() throws DAOException{
        List<Checks> uChecks = null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Checks> query = manager.createNamedQuery("Checks.NotClosed", Checks.class);
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            uChecks = query.getResultList();
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get checks",ex);
        } finally {
            manager.close();
        }
        return uChecks;
    }

    public List<Checks>NotClosedUsingCriteria()throws DAOException{

        List uChecks = null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;


        try {
            transaction = manager.getTransaction();

            transaction.begin();
            CriteriaBuilder cb=manager.getCriteriaBuilder();
            CriteriaQuery<Checks> criteria=cb.createQuery(Checks.class);
            Root<Checks> customer=criteria.from(Checks.class);
            criteria.select(customer);
            uChecks = manager.createQuery(criteria).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get check",ex);
        } finally {
            manager.close();
        }
        return uChecks;


    }


    public void createChecks(Checks user) throws DAOException{
    }
    public void deleteChecks (int id) throws DAOException {
    }
    public void updateChek (int id) throws DAOException {
    }
}
