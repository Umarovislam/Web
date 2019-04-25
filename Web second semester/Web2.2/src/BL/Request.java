package BL;

import javax.persistence.*;


@NamedQuery(name = "Request.getReqs",query = "select r.FirstName, r.size, r.days, r.requsetAt from Request r")
@Entity(name = "Request")
@Table(name = "Request")
public class Request {
    /**
     * @param=size count of rooms in  number
     * @param=days number of days of stay
     * @param=requsetAt reservation date
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "FirstName", nullable = false)
    private String FirstName;

    @Column(name = "Size", nullable = false)
    private int size;

    @Column(name = "Days", nullable = false)
    private int days;

    @Column(name = "RequestAt",nullable = false)
    private String requsetAt;

    public Request() {
    }
    public Request(String fn, int size, int days, String reqAt){
        this.FirstName = fn;
        this.size = size;
        this.days = days;
        this.requsetAt = reqAt;
    }
    public Request(Long id,String fn, int size, int days, String reqAt){
        this.id = id;
        this.FirstName = fn;
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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Override
    public String toString() {
        return "First Name " + getFirstName() + " room size " + getSize()+ " days "+getDays() + " Date At" + getRequsetAt() + "\n";
    }
}
