/*
 * @author Islam Umarov
 * @version 1.0
 * */
package Model;

abstract public class AccountBuilder {
    protected Customer customer;

    void createNewLeg(int ch){
        customer.createNewLegal(ch);
    }
    void createNewPhis(int ch){
        customer.createNewPhisic(ch);
    }
}
