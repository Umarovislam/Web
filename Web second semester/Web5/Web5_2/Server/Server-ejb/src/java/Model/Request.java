package Model;

import javax.persistence.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Request.getReqs",query = "select r from Request r")
@XmlRootElement
@Entity(name = "Request")
@Table(name = "Request")
public class Request implements Serializable {
    /**
     * @param=size count of rooms in  number
     * @param=days number of days of stay
     * @param=requsetAt reservation date
     * */
    @XmlAttribute
    @XmlID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private Long id;

    @XmlAttribute
    @Column(name = "Size", nullable = false)
    private int size;

    @XmlAttribute
    @Column(name = "Days", nullable = false)
    private int days;

    @XmlAttribute
    @Column(name = "RequestAt",nullable = false)
    private String requsetAt;

    public Request() {
    }
    public Request(int size, int days, String reqAt){
        //this.FirstName = fn;
        this.size = size;
        this.days = days;
        this.requsetAt = reqAt;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getRequsetAt() {
        return requsetAt;
    }

    public void setRequsetAt(String requsetAt) {
        this.requsetAt = requsetAt;
    }


    @Override
    public String toString() {
        return " room size " + getSize()+ " days "+getDays() + " Date At" + getRequsetAt() + "\n";
    }
}
