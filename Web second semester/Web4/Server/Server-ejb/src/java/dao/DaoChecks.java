package dao;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface DaoChecks {
    ArrayList<String> NotClosedChecks();
}
