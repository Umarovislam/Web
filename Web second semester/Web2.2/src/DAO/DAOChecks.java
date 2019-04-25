package DAO;

import BL.Checks;
import BL.Customer;
import BL.Number;

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
    public DAOChecks(){
        super(); }

    /**
     * @return found
     * @throws DAOException exception
     */


    public List<Checks>NotClosedChecks(){
        List<Checks> ch = null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Checks> query = manager.createNamedQuery("Checks.NotClosedChecks", Checks.class);
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            ch = query.getResultList();
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
        return ch;
    }


    public void createChecks(Checks user){
    }
    public void deleteChecks (int id) {
    }
    public void updateChek (int id){
    }
}
