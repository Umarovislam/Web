package Model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Check.NotClosed",query = "select c FROM Check c where c.closed=false")
@Table(name = "Chekc")
public class Check {
    /**
     * @param=closed uses to inform Admin that check was close
     * @param=sum represents sum of service
     * @param=NoId id of Number
     * @param=ReqId id of Request
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "closed")
    private boolean closed;

    @Column(name = "Sum",nullable = false)
    private int sum;

    @Column(name = "FirstName",nullable = false)
    private String firstName;

    @Column(name = "Number", nullable = false)
    private int Num;

    public Check(String firstName , int NoId, int sum, boolean closed){
        this.closed = closed;
        this.sum = sum;
        this.Num = NoId;
        this.firstName = firstName;
    }

    public Check() {
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
