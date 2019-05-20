package Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Number.Free", query = "select n FROM Number n where n.free=true")
@XmlRootElement
@Entity(name = "Number")
@Table(name = "Number")
public class Number implements Serializable {

    @XmlAttribute
    @XmlID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @XmlAttribute
    @Column(name = "no",nullable = false)
    private int no;

    @XmlAttribute
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
