package BL.Clons;

import BL.Service;
import BL.Subscriber;
import BL.SubscriberService;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Service.class)
public class Service_ {
    public static volatile SingularAttribute<Service, Long> id;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, Integer> cost;
    public static volatile ListAttribute<Service, SubscriberService> subscriberServices;
}
