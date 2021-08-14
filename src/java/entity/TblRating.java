/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Parth Computer
 */
@Entity
@Table(name = "tbl_rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRating.findAll", query = "SELECT t FROM TblRating t"),
    @NamedQuery(name = "TblRating.findByRatingId", query = "SELECT t FROM TblRating t WHERE t.ratingId = :ratingId"),
    @NamedQuery(name = "TblRating.findByRating", query = "SELECT t FROM TblRating t WHERE t.rating = :rating")})
public class TblRating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rating_id")
    private Integer ratingId;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private TblUser userName;

    public TblRating() {
    }

    public TblRating(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public TblRating(Integer ratingId, int rating) {
        this.ratingId = ratingId;
        this.rating = rating;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public TblUser getUserName() {
        return userName;
    }

    public void setUserName(TblUser userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRating)) {
            return false;
        }
        TblRating other = (TblRating) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblRating[ ratingId=" + ratingId + " ]";
    }
    
}
