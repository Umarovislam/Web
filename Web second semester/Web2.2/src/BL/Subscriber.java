package BL;
import java.io.Serializable;
import javax.persistence.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(
                name = "Subscriber.getAll",
                query = "from Subscriber s"
        ),
        @NamedQuery(name = "Subscriber.blockById",
                query = "update Subscriber set isBlocked = 1 where id = :id"),
        @NamedQuery(name = "Subscriber.servicesById",
                query = "select s from Service s join SubscriberService ss on s.id = ss.service.id where ss.subscriber.id = :id"),
        @NamedQuery(name = "Subscriber.getById",
                query = "from Subscriber where id = :id"),
        @NamedQuery(
                name = "Subscriber.deleteById",
                query = "delete from Subscriber where id = :id"),
        @NamedQuery(
                name = "Subscriber.updateById",
                query = "update Subscriber set name = :name, " +
                        "surname = :surname, " +
                        "patronymic = :patronymic, " +
                        "number = :number, " +
                        "isBlocked = :blocked " +
                        "where id = :id"),
}
)
@Entity(name="Subscriber")
@Table(name="subscriber")
public class Subscriber implements Serializable{
    @Id
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone_number")
    private String number;

    @Column(name = "blocked")
    private boolean isBlocked;

    @OneToMany(mappedBy = "subscriber", fetch = FetchType.LAZY)
    private Set<SubscriberService> subscriberServices = new HashSet<SubscriberService>();

    public Subscriber(){}
    public Subscriber(int id, String name, String surname, String patronymic, String number, boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.number = number;
        this.isBlocked = isBlocked;
    }

    public Subscriber(String name, String surname, String patronymic, String number, boolean isBlocked) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.number = number;
        this.isBlocked = isBlocked;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getNumber() {
        return number;
    }

    public boolean isBlocked() {
        return isBlocked;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", number='" + number + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }

    public Set<SubscriberService> getSubscriberServices() {
        return subscriberServices;
    }
}
