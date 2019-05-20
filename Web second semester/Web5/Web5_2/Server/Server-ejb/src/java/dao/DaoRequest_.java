package dao;


import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface DaoRequest_ {
    ArrayList<String> getRequests();
}
