package Controller;

import BL.Bill;
import BL.Service;
import BL.Subscriber;
import BL.SubscriberService;
import DAO.DAOBill;
import DAO.DAOService;
import DAO.DAOSubscriber;
import Exceptions.DAOException;

import javax.persistence.*;
import java.util.List;

public class Administrator {

    public Administrator() {
    }

    static public List<Service> getAllExistingServices(){
        DAOService daoService = new DAOService();
        return  daoService.getAll();
    }
    /**
     *  block user
     * @param id - user's id to block
     */
    static public void blockSub(long id){
        Logger.info("Blocking subscriber with id ="+id);
        new DAOSubscriber().blockSubscriber(id);
    }
    static public List<Bill> getBillsById(long subId){
        Logger.info("Getting all subscriber bills with id = "+"subId");
        DAOBill daoBill = new DAOBill();
        return daoBill.readBySubId(subId);
    }

    /**
     * pay the bill
     * @param billId - id of a bill to pay
     */
    static public void payBill(int billId){
        new DAOBill().payBill(billId);
    }

    /**
     * get all services connected to subscriber with particular id
     * @param subId id of subscriber
     * @return list of services
     */
    static public List<SubscriberService> getSubscriberServices(long subId){
        Logger.info("Getting all services of subscriber with id = "+subId);
        DAOSubscriber daoSubscriber = new DAOSubscriber();
        return daoSubscriber.getSubServices(subId);
    }
    static public Subscriber getSub(long id){

        return new DAOSubscriber().read(id);
    }


}
