package Controller;

import Model.Customer;

public class Demonstrate {
    public static void main(String[] args){
        Customer customer = new Customer("Ilya","Bobrov");
        customer.createNewPhisic(100);
        customer.createNewPhisic(200);
        customer.createNewPhisic(4000);
        customer.createNewPhisic(50);
        customer.createNewLegal(200);
        customer.createNewLegal(3400);
        customer.createNewLegal(3300);
        customer.createNewLegal(300);
        customer.sortPhisics();
        customer.getPhisicLocked();
        customer.Phisics.get(2).islocked();
        System.out.printf(customer.PhisicSum() + " \n");
        System.out.printf(customer.LegalSum() + " \n");
        System.out.printf(customer.CommonSum() + " \n");

        //System.out.print(customer.getPhisString());
    }
}
