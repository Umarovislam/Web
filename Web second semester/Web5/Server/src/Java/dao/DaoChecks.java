package dao;


import Model.Checks;
import java.io.Serializable;
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
import model.Form;

@WebService(serviceName = "DaoChecks")
public class DaoChecks implements Serializable{

    @PersistenceContext(unitName = "simple")
    EntityManager manager;
    
    @Inject
    UserTransaction ut;

    @WebMethod(operationName = "NotClosedChecks")
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
