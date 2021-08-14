package entity;

import entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblFeedback.class)
public class TblFeedback_ { 

    public static volatile SingularAttribute<TblFeedback, String> feedback;
    public static volatile SingularAttribute<TblFeedback, Integer> feebackId;
    public static volatile SingularAttribute<TblFeedback, TblUser> userName;

}