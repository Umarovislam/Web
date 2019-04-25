package DAO;

import BL.Clons.Subscriber_;
import BL.Service;
import BL.Subscriber;
import BL.SubscriberService;
import Controller.Logger;
import Exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DAOSubscriber extends DAO{

    public DAOSubscriber(){
        super();
    }
    public List<SubscriberService> getSubServices(long subId){
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SubscriberService> cq = cb.createQuery(SubscriberService.class);
        Root<SubscriberService> service = cq.from(SubscriberService.class);
        cq.select(service).where(cb.equal(service.get("subscriber").get("id"),subId));
        TypedQuery<SubscriberService> q = em.createQuery(cq);
        return q.getResultList();
    }
    /**
     * block user
     * @param id - id of user to block
     */
    public void blockSubscriber(long id){
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Subscriber> update = cb
                .createCriteriaUpdate(Subscriber.class);
        Root<Subscriber> subscriberRoot = update.from(Subscriber.class);
        update.where(cb.equal(subscriberRoot.get("id"),id));
        update.set(subscriberRoot.get("isBlocked"),true);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery(update).executeUpdate();
        transaction.commit();
    }
    /**
     * read subscriber service from database
     * @param id id of subsciber
     */
    public Subscriber read(long id){
        Logger.info("Read subscriber with id = " + id);
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subscriber> cq = cb.createQuery(Subscriber.class);
        Root<Subscriber> sub = cq.from(Subscriber.class);
        cq.select(sub).where(cb.equal(sub.get("id"),id));
        TypedQuery<Subscriber> q = em.createQuery(cq);
        return q.getResultList().get(0);
    }

    /**
     * delete subscriber from database
     * @param id id of subsciber
     */
    public void deleteUser (Integer id){
        Logger.info("Delte subscriber with id = " + id);
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Subscriber.deleteById").setParameter("id",id).executeUpdate();
        transaction.commit();
    }
    /**
     * update subscriber service in database
     * @param sub subsciber
     */
    public void update(Subscriber sub) throws DAOException {
        Logger.info("Update subscriber with id = " + sub.getId());
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Subscriber.updateById")
                .setParameter("id",sub.getId())
                .setParameter("name", sub.getName())
                .setParameter("surname", sub.getSurname())
                .setParameter("patronymic", sub.getPatronymic())
                .setParameter("number",sub.getNumber())
                .setParameter("blocked", sub.isBlocked())
                .executeUpdate();
        transaction.commit();

    }


}
