package Model;
/*
 * @author Islam Umarov
 * @version 1.0
 * Class Account describe the account of Customer @see Customer
 * */

public abstract class Account implements Comparable<Account> {
   /*
   * */
   private int account;

   public Account(){
      account = 0;
   }
   public int getAccount() {
      return account;
   }

   public void setAccount(int account) {
      this.account = account;
   }

   @Override
   public int compareTo(Account o) {
      return Integer.compare(this.account,o.account);
   }
   public abstract boolean islocked();
}