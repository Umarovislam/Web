package DAO;

import BL.Number;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOFree extends DAO{
    final String sql2 = "SELECT * FROM number where free=true ";

    /**
     * constructor for dao
     * @throws DAOException exception
     */
    public DAOFree(){
        super(); }

    public void createFree(Number num) {
    }
    public void deleteFree (int id)  {
    }


    public List<Number> getFreeNum (){
        List<Number> numbers = null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Number> query = manager.createNamedQuery("Number.Free", Number.class);
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            numbers = query.getResultList();
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
        return numbers;
    }
}
