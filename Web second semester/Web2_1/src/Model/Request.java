package Model;

public class Request {
    /**
    * @param=size count of rooms in  number
     * @param=days number of days of stay
     * @param=requsetAt reservation date
    * */
    private String FirstName;
    private int size;
    private int days;
    private String requsetAt;

    public Request() {
    }
    public Request(String fn, int size, int days, String reqAt){
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
