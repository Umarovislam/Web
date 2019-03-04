package Model;

public class Check {
    /**
     * @param=closed uses to inform Admin that check was close
     * @param=sum represents sum of service
     * @param=NoId id of Number
     * @param=ReqId id of Request
    */
    private boolean closed;
    private int sum;
    private String firstName;
    private int Num;

    public Check(String firstName , int NoId, int sum, boolean closed){
        this.closed = closed;
        this.sum = sum;
        this.Num = NoId;
        this.firstName = firstName;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    @Override
    public String toString() {
        return "Client: " + getFirstName() + " № "+getNum() + " SUM " + getSum() +  " Is closed " + isClosed() + "\n";
    }
}
