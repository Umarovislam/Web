package dao;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface DaoCustomer_{
    ArrayList<String> getCustomerbyName(String name);
    String getCustomerById(int id);

}
