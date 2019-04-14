package DAO;

import Model.Number;

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
    public DAOFree() throws DAOException{
        super(); }

    public void createFree(Number num) throws DAOException{
    }
    public void deleteFree (int id) throws DAOException {
    }


    public List<Number> getFreeNum () throws DAOException {
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
            throw new DAOException("can't get numbers",ex);
        } finally {
            manager.close();
        }
        return numbers;
    }
}
