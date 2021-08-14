package entity;

import entity.TblCar;
import entity.TblServiceDetail;
import entity.TblUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblServices.class)
public class TblServices_ { 

    public static volatile SingularAttribute<TblServices, Date> date;
    public static volatile SingularAttribute<TblServices, Float> total;
    public static volatile CollectionAttribute<TblServices, TblServiceDetail> tblServiceDetailCollection;
    public static volatile SingularAttribute<TblServices, String> serviceId;
    public static volatile SingularAttribute<TblServices, TblUser> userName;
    public static volatile SingularAttribute<TblServices, String> status;
    public static volatile SingularAttribute<TblServices, TblCar> carId;

}