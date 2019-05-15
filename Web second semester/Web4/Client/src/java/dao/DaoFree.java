package dao;


import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface DaoFree {
    ArrayList<String> getFreeNum ();
}
