package BL.Clons;

import BL.Subscriber;
import BL.SubscriberService;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Subscriber.class)
public class Subscriber_ {
    public static volatile SingularAttribute<Subscriber, Long> id;
    public static volatile SingularAttribute<Subscriber, String> name;
    public static volatile SingularAttribute<Subscriber, String> surname;
    public static volatile SingularAttribute<Subscriber, String> patronymic;
    public static volatile SingularAttribute<Subscriber, String> phone_number;
    public static volatile SingularAttribute<Subscriber, Boolean> isBlocked;
    public static volatile ListAttribute<Subscriber, SubscriberService> subscriberServices;

}
