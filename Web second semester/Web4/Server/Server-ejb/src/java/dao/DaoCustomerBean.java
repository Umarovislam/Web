package dao;


import Model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DaoCustomerBean implements DaoCustomer{


    public DaoCustomerBean(){}

    @PersistenceContext(unitName = "simple")
    EntityManager manager;


    @Override
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

    @Override
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
