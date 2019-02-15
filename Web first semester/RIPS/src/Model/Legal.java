/*
 * @author Islam Umarov
 * @version 1.0
 * */
package Model;

public class Legal extends Account{
    public static boolean block;
    private int subcheking;

    public Legal(int Chek){
        this.subcheking = Chek;
        this.setBlock(false);
    }

    public int getSubcheking() {
        return subcheking;
    }

    public void setSubcheking(int subcheking) {
        this.subcheking = subcheking;
    }

    @Override
    public boolean islocked() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
