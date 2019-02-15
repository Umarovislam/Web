/*
 * @author Islam Umarov
 * @version 1.0
 * */
package Model;

public class Phisic extends Account{
   private int cheking;
   private static boolean block = false;

   public Phisic(){}
   public Phisic(int Chek){
       this.cheking = Chek;
   }
    public int getCheking() {
        return cheking;
    }

    public void setCheking(int cheking) {
        this.cheking = cheking;
    }

    public static void setBlock(boolean block) {
        Phisic.block = block;
    }

    @Override
    public boolean islocked() {
        return block;
    }
}
