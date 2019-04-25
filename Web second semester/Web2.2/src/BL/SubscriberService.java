package BL;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity(name="SubscriberService")
@Table(name="subscriber_service")
public class SubscriberService implements Serializable {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "connection_date")
    Date connection;
    @Column(name = "disconnection_date")
    Date disconnection;

    public SubscriberService(Service service, Date connection, Date disconnection) {
        this.connection = connection;
        this.disconnection = disconnection;
    }

    public SubscriberService() {
    }

    public Date getConnection() {
        return connection;
    }

    public Date getDisconnection() {
        return disconnection;
    }


    public void setConnection(Date connection) {
        this.connection = connection;
    }

    public void setDisconnection(Date disconnection) {
        this.disconnection = disconnection;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
