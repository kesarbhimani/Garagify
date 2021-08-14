package entity;

import entity.TblCity;
import entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:43")
@StaticMetamodel(TblArea.class)
public class TblArea_ { 

    public static volatile CollectionAttribute<TblArea, TblUser> tblUserCollection;
    public static volatile SingularAttribute<TblArea, Integer> areaId;
    public static volatile SingularAttribute<TblArea, String> areaName;
    public static volatile SingularAttribute<TblArea, TblCity> cityId;

}