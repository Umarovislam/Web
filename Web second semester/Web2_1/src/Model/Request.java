package Model;

public class Request {
    /**
    * @param=size count of rooms in  number
     * @param=days number of days of stay
     * @param=requsetAt reservation date
    * */
    private int size;
    private int days;
    private String requsetAt;

    public Request() {
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
}
