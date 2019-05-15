/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;;
import dao.*;
import javax.ejb.EJB;
/**
 *
 * @author Islam
 */
public class Main {
    @EJB
    private static DaoChecks daoCheck;
    @EJB
    private static DaoCustomer daocus;
    @EJB
    private static DaoFree daoFree;
    @EJB
    private static DaoRequest req;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Получить счета");
        for(String s : daoCheck.NotClosedChecks()){
        System.out.println(s);
    }
        for(String s : daoFree.getFreeNum()){
        System.out.println(s);
    }
        for(String s : req.getRequests()){
            System.out.println(s);
    }
       /* System.out.println("Информация о пользователе по имени");
        for(String s : daocus.getCustomerbyName("Gerard")){
            System.out.println(s);
        }
        
        System.out.println("Информация о пользователе по Id");
        System.out.println(daocus.getCustomerById(5));*/
        
        
        // TODO code application logic here
    }
    
}
