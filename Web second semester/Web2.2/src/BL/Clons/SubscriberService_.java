package BL.Clons;

import BL.Service;
import BL.Subscriber;
import BL.SubscriberService;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(SubscriberService.class)
public class SubscriberService_ {
    public static volatile SingularAttribute<SubscriberService,Long> id;
    public static volatile SingularAttribute<SubscriberService,Date> connection;
    public static volatile SingularAttribute<SubscriberService,Date> disconnection;
    public static volatile SingularAttribute<SubscriberService, Service> service;
    public static volatile SingularAttribute<SubscriberService, Subscriber> subscriber;
}
