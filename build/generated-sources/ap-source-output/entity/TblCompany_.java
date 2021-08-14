package entity;

import entity.TblModel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblCompany.class)
public class TblCompany_ { 

    public static volatile SingularAttribute<TblCompany, Integer> companyId;
    public static volatile CollectionAttribute<TblCompany, TblModel> tblModelCollection;
    public static volatile SingularAttribute<TblCompany, String> companyName;

}