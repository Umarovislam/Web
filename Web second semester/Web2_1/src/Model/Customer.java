package Model;

public class Customer {
    private String FirstName;
    private String LastName;
    private boolean request;

    public Customer(String firstName, String lastName, boolean request) {
        FirstName = firstName;
        LastName = lastName;
        this.request = request;
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
