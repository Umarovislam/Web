package dao;


import Model.Checks;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DaoChecksBean implements DaoChecks{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;


    @Override
    public ArrayList<String> NotClosedChecks(){
        List<Checks> ch = null;
        ArrayList<String>rr = new ArrayList<String>();
        TypedQuery<Checks> query = manager.createQuery("select c from Checks c where c.closed = false",Checks.class);
        try {
            ch = query.getResultList();
            if(ch != null)
                for(Checks bo:ch)
                    rr.add(bo.toString());
        }catch (Exception ex) {
            throw ex;
        }
        return rr;
    }
}
