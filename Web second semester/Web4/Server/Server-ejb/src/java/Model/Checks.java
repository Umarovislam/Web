package Model;

import javax.persistence.*;
import java.io.Serializable;

//@NamedQuery(name = "Checks.NotClosedChecks", query = "select c from Checks c where c.closed = false")
@Entity(name = "Checks")
@Table(name = "checks")
public class Checks implements Serializable {
    /**
     * @param=closed uses to inform Admin that Checks was close
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

    @Column(name = "CustomerId",nullable = false)
    private Long customerId;

    @Column(name = "RequestId", nullable = false)
    private int Num;

    public Checks(int NoId, int sum, boolean closed, Long customerId){
        this.closed = closed;
        this.sum = sum;
        this.Num = NoId;
        this.customerId = customerId;
    }
    public Checks(long id, boolean closed, int sum, long customerId,int NoId){
        this.id = id;
        this.closed = closed;
        this.sum = sum;
        this.Num = NoId;
        this.customerId =customerId;
    }

    public Checks() {
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


    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    @Override
    public String toString() {
        return "Client: " + this.customerId + " № "+getNum() + " SUM " + getSum() +  " Is closed " + isClosed() + "\n";
    }
}
