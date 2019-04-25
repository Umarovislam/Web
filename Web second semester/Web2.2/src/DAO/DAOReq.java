package DAO;

import BL.Request;
import BL.Service;
import Controller.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DAOReq extends DAO{
   // final String sq3 = "SELECT cs.FirstName,r.size,r.days,r.RequestedAt  FROM request r join customer cs on r.CustmerId = cs.id";


    /**
     * access database
     *
     * @throws DAOException
     */
    public DAOReq(){
        super();
    }
    public List<Request> getRequests(){
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
        } finally {
            manager.close();
        }
        return requests;
    }

    public List<Request> getAllReqs(){
        Logger.info("Read all services");
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Request> cq = cb.createQuery(Request.class);
        Root<Request> req = cq.from(Request.class);
        cq.select(req);
        TypedQuery<Request> q = em.createQuery(cq);
        return q.getResultList();
    }
}
