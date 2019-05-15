package dao;

import Model.Number;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DaoFreeBean implements DaoFree{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;

    @Override
    public ArrayList<String> getFreeNum(){
        List<Number> ch = null;
        ArrayList<String>rr = new ArrayList<String>();
        TypedQuery<Number> query = manager.createQuery("select n FROM Number n where n.free=true",Number.class);
        try {
            ch = query.getResultList();
            if(ch != null)
                for(Number bo:ch)
                    rr.add(bo.toString());
        }catch (Exception ex) {
            throw ex;
        }
        return rr;
    }
}
