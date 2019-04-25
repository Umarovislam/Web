
import BL.Bill;
import BL.Service;
import BL.Subscriber;
import BL.SubscriberService;
import Controller.Administrator;
import Exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void printMenu(){
        System.out.println("1 - block subscriber");
        System.out.println("2 - print all existing services");
        System.out.println("3 - print subscriber bill");
        System.out.println("4 - pay a bill");
        System.out.println("5 - print subscriber services");
    }

    /**
     * print all existing services
     */


    private static EntityManagerFactory factory;
    private static EntityManager em;
    public static void main(String[] args) {
        char c=1;
        int id =-1;
        Subscriber sub = null;
        Administrator admin = new Administrator();
        Scanner scanner = new Scanner(System.in);
        do{
            printMenu();
            c=scanner.nextLine().charAt(0);
            switch (c){
                case '1':
                    System.out.println("Enter sub id");
                    id = Integer.parseInt(scanner.nextLine());
                    Administrator.blockSub(id);
                    sub = Administrator.getSub(id);
                    System.out.println("Sub "+sub.getName()+" "+sub.getSurname()+" is blocked");
                    break;
                case '2':
                    System.out.println("Services:");
                    for (Service s:Administrator.getAllExistingServices()) {
                        System.out.println(s);
                    }
                    break;
                case '3':
                    System.out.println("Enter sub id");
                    id = Integer.parseInt(scanner.nextLine());
                    sub = Administrator.getSub(id);
                    System.out.println("Bills of "+sub.getSurname()+" "+sub.getName()+":\n");
                    for(Bill b: Administrator.getBillsById(1)){
                        System.out.println(b);
                    }
                    break;
                case '4':
                    System.out.println("Enter bill id\n");
                    id = Integer.parseInt(scanner.nextLine());
                    Administrator.payBill(id);
                    System.out.println("Bill is payed");
                    break;
                case '5':
                    System.out.println("Enter sub id\n");
                    id = Integer.parseInt(scanner.nextLine());
                    sub = Administrator.getSub(id);
                    System.out.println("Services of " + sub.getName()+" "+sub.getSurname());
                        for (SubscriberService ss:Administrator.getSubscriberServices(id))
                            System.out.println(ss.getService());
                    break;
            }

        }
        while(c!='0');
}
}
