package dao;


import Model.Request;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DaoRequestBean implements DaoRequest{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;

    @Override
    public ArrayList<String> getRequests() {
        List<Request> req=null;
        ArrayList<String> fm = new ArrayList<String>();
        TypedQuery<Request> query = manager.createQuery("select r from Request r", Request.class);

        try {
             req = query.getResultList();
            for(Request f:req)
                fm.add("Request \n" + f.toString());
        } catch (Exception ex) {
            throw ex;
        }
        return fm;
    }
}
