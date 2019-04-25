package DAO;

import BL.Service;
import Exceptions.DAOException;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {
    EntityManagerFactory factory;
    public DAO(){
        factory = Persistence.createEntityManagerFactory("FirstPersistenceUnit");
    }

    protected EntityManager getManager() {
        return factory.createEntityManager();
    }

    public void close(){
        factory.close();
    }
    /**
     * create object with certain id from database
     * @param object to add
     */
    public void create(Object object){
        EntityManager entityManager= getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        log(object.getClass()+" is created");
    }
    static void log(String str){
        Logger.getLogger("logger").info(str);
    }

}