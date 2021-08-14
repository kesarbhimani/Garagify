package entity;

import entity.TblModel;
import entity.TblServices;
import entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblCar.class)
public class TblCar_ { 

    public static volatile SingularAttribute<TblCar, String> fuelName;
    public static volatile CollectionAttribute<TblCar, TblServices> tblServicesCollection;
    public static volatile SingularAttribute<TblCar, String> colorName;
    public static volatile SingularAttribute<TblCar, String> carNo;
    public static volatile SingularAttribute<TblCar, TblModel> modelId;
    public static volatile SingularAttribute<TblCar, TblUser> userName;
    public static volatile SingularAttribute<TblCar, Integer> carId;

}