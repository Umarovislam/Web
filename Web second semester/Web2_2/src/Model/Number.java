package Model;


import javax.persistence.*;

@Entity
@NamedQuery(name = "Number.Free", query = "select n FROM Number n where n.free=true")
@Table(name = "Number")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "no",nullable = false)
    private int no;

    @Column(name = "free", nullable = false)
    private boolean free;


    public Number(int num, boolean free_){
        this.no = num;
        this.free = free_;
    }
    public Number(){}

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public String toString(){
        return "Hotel number: "+ this.no + " Free " + free + "\n";
    }
}
