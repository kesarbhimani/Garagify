package entity;

import entity.TblArea;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblCity.class)
public class TblCity_ { 

    public static volatile SingularAttribute<TblCity, String> cityName;
    public static volatile CollectionAttribute<TblCity, TblArea> tblAreaCollection;
    public static volatile SingularAttribute<TblCity, Integer> cityId;

}