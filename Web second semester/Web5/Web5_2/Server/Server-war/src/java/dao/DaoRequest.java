package dao;


import Model.Request;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@WebService(serviceName = "DaoRequest")
public class DaoRequest implements DaoRequest_{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;

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
