package BL;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@NamedQueries({
        @NamedQuery(
                name = "Bill.getBillsBySubID",
                query = "from Bill where subscriberService.subscriber.id = :id"
        ),
        @NamedQuery(
                name = "Bill.payById",
                query = "update Bill set isPaid = 1 where id = :id"),
        @NamedQuery(
                name = "Bill.getBillByID",
                query = "from Bill where id = :id"),
        @NamedQuery(
                name = "Bill.deleteByID",
                query = "delete from Bill where id = :id"),
        @NamedQuery(
                name = "Bill.updateByID",
                query = "update Bill set " +
//                        "from = :from, " +
//                        "to=:to, " +
                        "isPaid = :paid where id = :id")
}
)
@Entity(name= "Bill")
@Table(name = "bill")
public class Bill implements Serializable{
    @Id
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subscriber_service_id")
    private SubscriberService subscriberService;

    @Column(name = "from_date")
    Date from;
    @Column(name = "to_date")
    Date to;
    @Column(name = "paid")
    boolean isPaid;

    public Bill(int id, int subscriberServiceID, Date from, Date to, boolean isPaid) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.isPaid = isPaid;
    }

    public Bill() {
    }


    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SubscriberService getSubscriberService() {
        return subscriberService;
    }

    public void setSubscriberService(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", subscriberService=" + subscriberService +
                ", from=" + from +
                ", to=" + to +
                ", isPaid=" + isPaid +
                '}';
    }
}
