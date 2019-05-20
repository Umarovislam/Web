package dao;

import javax.ejb.Remote;
import java.util.ArrayList;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DaoChecks.class)
public interface DaoChecks_ {
   public  ArrayList<String> NotClosedChecks();
}
