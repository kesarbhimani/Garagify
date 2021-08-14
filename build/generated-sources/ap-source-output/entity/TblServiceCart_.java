package entity;

import entity.TblServiceType;
import entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblServiceCart.class)
public class TblServiceCart_ { 

    public static volatile SingularAttribute<TblServiceCart, Integer> scartId;
    public static volatile SingularAttribute<TblServiceCart, TblServiceType> serviceTypeId;
    public static volatile SingularAttribute<TblServiceCart, TblUser> userName;

}