package Model;

import javax.persistence.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;


/*@NamedQueries({
        @NamedQuery(name="Customer.customerById",query = "FROM Customer c where c.id = :id"),
        @NamedQuery(name = "Customer.AllCustomers", query = "FROM Customer c")
})*/
@XmlRootElement
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer implements Serializable {
    
     @XmlAttribute
   @XmlID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

     @XmlAttribute
    @Column(name = "FirstName", nullable = false)
    private String FirstName;

     @XmlAttribute
    @Column(name = "LastName", nullable = true)
    private String LastName;

     @XmlAttribute
    @Column(name = "request",nullable = false)
    private boolean request;

    public Customer(String firstName, String lastName, boolean request) {
        FirstName = firstName;
        LastName = lastName;
        this.request = request;
    }
    public Customer(Long id,String firstName, String lastName, boolean request) {
        this.id = id;

        FirstName = firstName;
        LastName = lastName;
        this.request = request;
    }

    public Customer() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

}
