package BL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@NamedQueries({
        @NamedQuery(
                name = "Service.getAllServices",
                query = "from Service"
        ),
        @NamedQuery(
                name = "Service.getById",
                query = "from Service where id = :id"
        ),@NamedQuery(
        name = "Service.deleteById",
        query = "delete from Service where id = :id"),
        @NamedQuery(
        name = "Service.updateById",
        query = "update Service set name = :name, cost = :cost where id = :id"),
}
)
@Entity(name="Service")
@Table(name="service")
public class Service implements Serializable {
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;

    @OneToMany(mappedBy = "service",
                fetch = FetchType.LAZY)
    private Set<SubscriberService> subscriberServices = new HashSet<SubscriberService>();

    public Service(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Service() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
