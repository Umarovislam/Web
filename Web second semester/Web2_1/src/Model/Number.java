package Model;

public class Number {
    private int no;
    private boolean free;

    public Number(int num, boolean free_){
        this.no = num;
        this.free = free_;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public String toString(){
        return "Hotel number: "+ this.no + " Free " + free + "\n";
    }
}
