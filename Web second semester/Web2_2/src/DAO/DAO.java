package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    private EntityManagerFactory emFactory;
    /**
     * access database
     * @throws DAOException
     */
    public DAO() throws DAOException
    {
            emFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    }
    /**
     * get connector
     * @return connector
     */
    protected EntityManager getManager() {
        return emFactory.createEntityManager();
    }

    public void close(){
        emFactory.close();
    }

}
