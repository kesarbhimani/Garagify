package entity;

import entity.TblCar;
import entity.TblCompany;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblModel.class)
public class TblModel_ { 

    public static volatile SingularAttribute<TblModel, String> modelName;
    public static volatile SingularAttribute<TblModel, TblCompany> companyId;
    public static volatile SingularAttribute<TblModel, Integer> modelId;
    public static volatile CollectionAttribute<TblModel, TblCar> tblCarCollection;

}