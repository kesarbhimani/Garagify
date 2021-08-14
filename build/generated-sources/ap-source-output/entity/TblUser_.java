package entity;

import entity.TblArea;
import entity.TblCar;
import entity.TblFeedback;
import entity.TblGroup;
import entity.TblRating;
import entity.TblServiceCart;
import entity.TblServices;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblUser.class)
public class TblUser_ { 

    public static volatile CollectionAttribute<TblUser, TblGroup> tblGroupCollection;
    public static volatile SingularAttribute<TblUser, String> lastName;
    public static volatile SingularAttribute<TblUser, String> address;
    public static volatile SingularAttribute<TblUser, Date> joinningDate;
    public static volatile CollectionAttribute<TblUser, TblRating> tblRatingCollection;
    public static volatile SingularAttribute<TblUser, String> userName;
    public static volatile SingularAttribute<TblUser, Integer> userId;
    public static volatile CollectionAttribute<TblUser, TblFeedback> tblFeedbackCollection;
    public static volatile SingularAttribute<TblUser, String> phoneNo;
    public static volatile CollectionAttribute<TblUser, TblServices> tblServicesCollection;
    public static volatile SingularAttribute<TblUser, String> firstName;
    public static volatile SingularAttribute<TblUser, String> password;
    public static volatile SingularAttribute<TblUser, TblArea> areaId;
    public static volatile CollectionAttribute<TblUser, TblServiceCart> tblServiceCartCollection;
    public static volatile CollectionAttribute<TblUser, TblCar> tblCarCollection;
    public static volatile SingularAttribute<TblUser, String> email;
    public static volatile SingularAttribute<TblUser, String> status;

}