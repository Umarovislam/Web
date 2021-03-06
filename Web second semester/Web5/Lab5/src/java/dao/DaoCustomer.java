package dao;



import Model.Customer;
import java.io.Serializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;


@WebService(serviceName = "DaoCustomer")
public class DaoCustomer implements DaoCustomer_{
    
    @PersistenceContext(unitName = "simple")
    EntityManager manager;
    
    @Inject
    UserTransaction ut;

    @WebMethod(operationName = "getCustomerbyName")
    public ArrayList<String> getCustomerbyName(String name) {
        List<Customer> Customers = null;
        ArrayList<String> rr = new ArrayList<String>();
        TypedQuery<Customer> query = manager.createQuery("SELECT b from Customer b WHERE b.FirstName = ?1", Customer.class);
        query.setParameter(1, name);
        try {
            Customers = query.getResultList();
            if(Customers != null)
                for(Customer bo:Customers)
                    rr.add(bo.toString());
        } catch (Exception ex) {
            throw ex;
        }
        return rr;
    }
    @WebMethod(operationName = "getCustomerById")
    public String getCustomerById(int id) {
        Customer cs = new Customer();
        String csstr = null;
        TypedQuery<Customer> query = manager.createQuery("SELECT b from Customer b WHERE b.id = ?1", Customer.class);
        query.setParameter(1, id);
        try {
             cs = (Customer) query.getResultList();
            if(cs != null)
                csstr = cs.toString();
        } catch (Exception ex) {
            throw ex;
        }
        return csstr;
    }
}
