package Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    private Long id;

    private String FirstName;
    private String LastName;
    private boolean request;

    public Customer(String firstName, String lastName, boolean request) {
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
