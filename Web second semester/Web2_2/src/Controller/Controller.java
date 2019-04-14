package Controller;

import DAO.DAOChecks;
import DAO.DAOException;
import DAO.DAOFree;
import DAO.DAOReq;
import Model.Checks;
import Model.Number;
import Model.Request;

import java.util.List;

public class Controller {


    public String getNumList(){
        List<Number> nums = null;
        String str = "";
        try{
            nums = (new DAOFree()).getFreeNum();
        if (nums.isEmpty()){
            return "Number list is empty";
        }
        else {
            for (Number number : nums){
                str += number.toString();
            }
        }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public String getCheck(){
        String str ="";
        List<Checks> checks = null;
        try{
            checks = (new DAOChecks()).NotClosedChecks();
            if (checks.isEmpty()){
                return "Number list is empty";
            }
            else {
                for (Checks ch : checks){
                    str += ch.toString();
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public String getReqList(){
        String str = "";
        List<Request> requests =null;
        try{
            requests = (new DAOReq()).getRequests();
            if (requests.isEmpty()){
                return "Number list is empty";
            }
            else {
                for (Request rq : requests){
                    str += rq.toString();
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
