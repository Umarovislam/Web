package Model;
/*
* @author Islam Umarov
* @version 1.0
* */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer{
    /*
    * Customer's First Name
    */
    private String FirstName;

    /*
     * Customer's Last Name
     */
    private String LastName;

    /*
     * Customer bank account
     */
    public ArrayList<Legal>Legals = new ArrayList<>();
    public ArrayList<Phisic>Phisics = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
    public Customer(){}

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void createNewLegal(int Check) {
        Legal legal = new Legal(Check);
        Legals.add(legal);
    }
    public void createNewPhisic(int Check){
        assert (Check < 0);
        Phisic phisic = new Phisic(Check);
        Phisics.add(phisic);
    }
    public ArrayList<Legal> getAllLegal(){
        assert(Legals.isEmpty());
        return Legals;
    }
    public void getAllPhisic(){
        if(!Legals.isEmpty()){
            getLegals();
        }
        else {
            System.out.printf("isn't exist any phisic account \n");
        }
    }

    public ArrayList<Phisic>getPhisics(){
        return Phisics;
    }

    public ArrayList<Legal>getLegals(){
        return Legals;
    }
    public String getPhisString(){
        assert(Phisics.isEmpty());
        String str = new String();
        for (int i=0; i < Phisics.size(); i++){
            str +=  Phisics.get(i)+ " \n";
        }
        return str;
    }
    public ArrayList<Legal>sortLegals(){
        ArrayList<Legal> Legals1 = Legals;
        Collections.sort(Legals1, new Comparator<Legal>() {
            @Override
            public int compare(Legal o1, Legal o2) {
                return o1.getSubcheking() - o2.getSubcheking();
            }
        });
        return Legals1;
    }
    public ArrayList<Phisic>sortPhisics(){
        ArrayList<Phisic> Phisics1 = Phisics;
        Collections.sort(Phisics1, new Comparator<Phisic>() {
            @Override
            public int compare(Phisic o1, Phisic o2) {
                return o1.getCheking() - o2.getCheking();
            }
        });
        return Phisics1;
    }
    public int LegalSum(){
        int sum = 0;
        if(Legals.isEmpty()){
            System.out.printf("you don't have any legal check \n");
        }
        else {
            for(Legal leg : Legals){
                sum += leg.getSubcheking();
            }
        }
        return sum;
    }
    public int PhisicSum(){
        int sum = 0;
        if(Phisics.isEmpty()){
            System.out.printf("you don't have any phisic check \n");
        }
        else {
            for(Phisic leg : Phisics){
                sum += leg.getCheking();
            }
        }
        return sum;
    }
    public int CommonSum(){
        return LegalSum()+PhisicSum();
    }

    public void getAllLocked(){
        if(Legals.isEmpty() && Phisics.isEmpty()){
            System.out.printf("you don't have any account \n");
        }
        else {
            if (!getLegalLocked().isEmpty()){
                System.out.printf(getLegalLocked().toString()+ " Locked legal \n");
            }
            if (!getPhisicLocked().isEmpty()){
                System.out.printf(getLegalLocked().toString() + " Locked phisic \n");
            }
        }
    }
    public ArrayList<Legal> getLegalLocked(){
        ArrayList<Legal>locked = new ArrayList<>();
        if(Legals.isEmpty()){
            System.out.printf("you don't have any legal account \n");
            return locked;
        }
        else {
            for (Legal leg : Legals){
                if (leg.islocked()){
                    locked.add(leg);
                }
            }
            return locked;
        }
    }
    public ArrayList<Phisic> getPhisicLocked(){
        ArrayList<Phisic>locked = new ArrayList<>();
        if(Phisics.isEmpty()){
            System.out.printf("you don't have any legal account \n");
            return locked;
        }
        else {
            for (Phisic ph : Phisics){
                if (ph.islocked()){
                    locked.add(ph);
                }
            }
            return locked;
        }
    }
   /* public String toString(ArrayList<?> array){
        String str = new String();
        for (Object arrayList : array){
            str += arrayList.toString() + "\n";
        }
        return str;
    }*/
}
