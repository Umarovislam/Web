package Controller;

import DAO.DAOChecks;
import DAO.DAOException;
import DAO.DAOFree;
import Model.Check;
import Model.Number;

import java.util.ArrayList;

public class Controller {


    public String getNumList(){
        ArrayList<Number> nums = new ArrayList<>();
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
        ArrayList<Check> checks = new ArrayList<>();
        try{
            checks = (new DAOChecks()).NotClosedChecks();
            if (checks.isEmpty()){
                return "Number list is empty";
            }
            else {
                for (Check ch : checks){
                    str += ch.toString();
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
