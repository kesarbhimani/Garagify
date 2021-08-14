package entity;

import entity.TblServiceType;
import entity.TblServices;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblServiceDetail.class)
public class TblServiceDetail_ { 

    public static volatile SingularAttribute<TblServiceDetail, TblServiceType> serviceTypeId;
    public static volatile SingularAttribute<TblServiceDetail, Integer> sdetailId;
    public static volatile SingularAttribute<TblServiceDetail, TblServices> serviceId;
    public static volatile SingularAttribute<TblServiceDetail, String> status;

}