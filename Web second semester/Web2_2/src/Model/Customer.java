package Model;


import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="cusromer.customerById",query = "SELECT c FROM Customer c where c.id = ?1"),
        @NamedQuery(name = "Customer.customerByName", query = "select c FROM Customer c where c.FirstName = ?1")
})

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "First name", nullable = false)
    private String FirstName;

    @Column(name = "Last name", nullable = true)
    private String LastName;

    @Column(name = "request",nullable = false)
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
