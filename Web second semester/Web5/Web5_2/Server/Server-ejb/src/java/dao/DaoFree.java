package dao;

import Model.Number;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.UserTransaction;

@WebService(serviceName = "DaoFree")
public class DaoFree implements DaoFree_{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;

    @Inject
    UserTransaction ut;
    
    @WebMethod(operationName = "getFreeNum")
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
