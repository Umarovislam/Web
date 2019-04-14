package DAO;

import Model.Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOReq extends DAO{
   // final String sq3 = "SELECT cs.FirstName,r.size,r.days,r.RequestedAt  FROM request r join customer cs on r.CustmerId = cs.id";


    /**
     * access database
     *
     * @throws DAOException
     */
    public DAOReq() throws DAOException {
        super();
    }
    public List<Request> getRequests() throws DAOException{
        List<Request> requests=null;
        EntityManager manager = this.getManager();
        EntityTransaction transaction = null;
        TypedQuery<Request> query = manager.createNamedQuery("Request.getReqs", Request.class);
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            requests = query.getResultList();
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("can't get any requests",ex);
        } finally {
            manager.close();
        }
        return requests;
    }
}
