package BL.Clons;

import BL.Bill;
import BL.SubscriberService;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

//@Static Metamodel(Bill.class)
@StaticMetamodel(Bill.class)
public class Bill_ {
    public static volatile SingularAttribute<Bill, Long> id;
    public static volatile SingularAttribute<Bill, Date> from;
    public static volatile SingularAttribute<Bill, Date> to;
    public static volatile SingularAttribute<Bill, Boolean> isPaid;
    public static volatile SingularAttribute<Bill, SubscriberService> subscriberService;

}
