package DAO;

import BL.Service;
import Controller.Logger;
import Exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DAOService extends DAO{

    public DAOService(){
        super();
    }
    /**
     * read list of all existing services from database
     * @return list of all existing services
     */
    public List<Service> getAll(){
        Logger.info("Read all services");
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Service> cq = cb.createQuery(Service.class);
        Root<Service> service = cq.from(Service.class);
        cq.select(service);
        TypedQuery<Service> q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * read services with certain id from database
     * @return services with certain id
     */
    public Service read(Integer id) throws DAOException{
        Logger.info("Read service with id = " + id);
        EntityManager entityManager= getManager();
        return entityManager.createNamedQuery("Service.getById", Service.class).getResultList().get(0);
    }

    /**
     * delete service with certain
     * @param id  id of service to delete
     */
    public void delete (Integer id) throws DAOException {
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Service.deleteById").setParameter("id",id).executeUpdate();
        transaction.commit();
        Logger.info("Delete bill with id = " + id);
    }
    /**
     * update service
     * @param service  id of service to delete
     */
    public void update(Service service) throws DAOException {
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Service.updateById")
                .setParameter("id",service.getId())
                .setParameter("name",service.getName())
                .setParameter("cost",service.getCost())
                .executeUpdate();
        transaction.commit();
        Logger.info("Update service with id = " + service.getId());
    }

}
