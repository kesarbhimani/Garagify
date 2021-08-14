package entity;

import entity.TblServiceCart;
import entity.TblServiceDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblServiceType.class)
public class TblServiceType_ { 

    public static volatile SingularAttribute<TblServiceType, String> serviceType;
    public static volatile SingularAttribute<TblServiceType, String> image;
    public static volatile CollectionAttribute<TblServiceType, TblServiceCart> tblServiceCartCollection;
    public static volatile CollectionAttribute<TblServiceType, TblServiceDetail> tblServiceDetailCollection;
    public static volatile SingularAttribute<TblServiceType, Float> price;
    public static volatile SingularAttribute<TblServiceType, Integer> serviceTypeId;
    public static volatile SingularAttribute<TblServiceType, String> description;

}