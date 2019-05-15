package dao;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface DaoCustomer {
    ArrayList<String> getCustomerbyName(String name);
    String getCustomerById(int id);

}
