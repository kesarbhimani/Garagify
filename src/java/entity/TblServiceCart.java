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
@Table(name = "tbl_service_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServiceCart.findAll", query = "SELECT t FROM TblServiceCart t"),
    @NamedQuery(name = "TblServiceCart.findByScartId", query = "SELECT t FROM TblServiceCart t WHERE t.scartId = :scartId")})
public class TblServiceCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scart_id")
    private Integer scartId;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private TblUser userName;
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    @ManyToOne(optional = false)
    private TblServiceType serviceTypeId;

    public TblServiceCart() {
    }

    public TblServiceCart(Integer scartId) {
        this.scartId = scartId;
    }

    public Integer getScartId() {
        return scartId;
    }

    public void setScartId(Integer scartId) {
        this.scartId = scartId;
    }

    public TblUser getUserName() {
        return userName;
    }

    public void setUserName(TblUser userName) {
        this.userName = userName;
    }

    public TblServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(TblServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scartId != null ? scartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServiceCart)) {
            return false;
        }
        TblServiceCart other = (TblServiceCart) object;
        if ((this.scartId == null && other.scartId != null) || (this.scartId != null && !this.scartId.equals(other.scartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblServiceCart[ scartId=" + scartId + " ]";
    }
    
}
