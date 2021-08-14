package entity;

import entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-03T16:36:44")
@StaticMetamodel(TblRating.class)
public class TblRating_ { 

    public static volatile SingularAttribute<TblRating, Integer> ratingId;
    public static volatile SingularAttribute<TblRating, Integer> rating;
    public static volatile SingularAttribute<TblRating, TblUser> userName;

}