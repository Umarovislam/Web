package DAO;

import BL.Bill;
import BL.Service;
import BL.Subscriber;
import Controller.Logger;
import Exceptions.DAOException;
import com.mysql.cj.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOBill extends DAO {

    public DAOBill(){
        super();
    }
    public void payBill(int billID){
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Bill> update = cb
                .createCriteriaUpdate(Bill.class);
        Root<Bill> subscriberRoot = update.from(Bill.class);
        update.where(cb.equal(subscriberRoot.get("id"),billID));
        update.set(subscriberRoot.get("isPaid"),true);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery(update).executeUpdate();
        transaction.commit();
    }
    /**
     * read all bill of certain subscriber
     * @param subID id of the subscriber
     * @return list of bills
     */
    public List<Bill> readBySubId(long subID){
        Logger.info("Read bill with id = " + subID);
        EntityManager em= getManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bill> cq = cb.createQuery(Bill.class);
        Root<Bill> bill = cq.from(Bill.class);
        cq.select(bill).where(cb.equal(bill.get("subscriberService").get("subscriber").get("id"),subID));
        TypedQuery<Bill> q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * read bill from database
     * @param billId id of the bill
     */
    public Bill read(long billId) throws DAOException{
        Logger.info("Read bill with id = " + billId);
        EntityManager entityManager= getManager();
        return entityManager.createNamedQuery("Bill.getBillByID",Bill.class).setParameter("id", billId).getResultList().get(0);
    }

    /**
     * delete bill
     * @param billID id of the bill to delete
     */
    public void delete(long billID) throws DAOException {
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Bill.deleteByID").setParameter("id",billID).executeUpdate();
        transaction.commit();
        Logger.info("read");
    }
    /**
     * update bill
     */
    public void update(Bill bill) throws DAOException {
        EntityTransaction transaction = null;
        EntityManager entityManager= getManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createNamedQuery("Bill.updateByID")
                .setParameter("id",bill.getId())
                //.setParameter("subscriberService",bill.getSubscriberService())
//                .setParameter("from", bill.getFrom().toString())
                //.setParameter("to", bill.getTo())
//                .setParameter("paid", bill.isPaid())
                .executeUpdate();
        transaction.commit();
        Logger.info("Bill id="+ bill.getId()+" is updated");
    }
}
