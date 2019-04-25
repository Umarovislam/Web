package Controller;

import BL.Checks;
import BL.Number;
import BL.Request;
import DAO.DAOChecks;
import DAO.DAOFree;
import DAO.DAOReq;

import java.util.List;

public class Controller {


    public String getNumList()  {
        List<Number> nums = null;
        String str = "";
        nums = (new DAOFree()).getFreeNum();
        if (nums.isEmpty()){
            return "Number list is empty";
        }
        else {
            for (Number number : nums){
                str += number.toString();
            }
        }
        return str;
    }
    public String getCheck(){
        String str ="";
        List<Checks> checks =  (new DAOChecks()).NotClosedChecks();
            if (checks.isEmpty()){
                return "Number list is empty";
            }
            else {
                for (Checks ch : checks){
                    str += ch.toString();
                }
            }
        return str;
    }
    public String getReqList(){
        String str = "";
        List<Request> requests =null;
        requests = (new DAOReq()).getRequests();
        if (requests.isEmpty()){
            return "Number list is empty";
        }
        else {
            for (Request rq : requests){
                str += rq.toString();
            }
        }
        return str;
    }
}
