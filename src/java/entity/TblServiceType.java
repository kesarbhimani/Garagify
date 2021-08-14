/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Parth Computer
 */
@Entity
@Table(name = "tbl_service_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServiceType.findAll", query = "SELECT t FROM TblServiceType t"),
    @NamedQuery(name = "TblServiceType.findByServiceTypeId", query = "SELECT t FROM TblServiceType t WHERE t.serviceTypeId = :serviceTypeId"),
    @NamedQuery(name = "TblServiceType.findByServiceType", query = "SELECT t FROM TblServiceType t WHERE t.serviceType = :serviceType"),
    @NamedQuery(name = "TblServiceType.findByImage", query = "SELECT t FROM TblServiceType t WHERE t.image = :image"),
    @NamedQuery(name = "TblServiceType.findByDescription", query = "SELECT t FROM TblServiceType t WHERE t.description = :description"),
    @NamedQuery(name = "TblServiceType.findByPrice", query = "SELECT t FROM TblServiceType t WHERE t.price = :price")})
public class TblServiceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    @Basic(optional = false)
    @Column(name = "service_type")
    private String serviceType;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceTypeId")
    private Collection<TblServiceDetail> tblServiceDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceTypeId")
    private Collection<TblServiceCart> tblServiceCartCollection;

    public TblServiceType() {
    }

    public TblServiceType(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public TblServiceType(Integer serviceTypeId, String serviceType, String image, String description, float price) {
        this.serviceTypeId = serviceTypeId;
        this.serviceType = serviceType;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<TblServiceDetail> getTblServiceDetailCollection() {
        return tblServiceDetailCollection;
    }

    public void setTblServiceDetailCollection(Collection<TblServiceDetail> tblServiceDetailCollection) {
        this.tblServiceDetailCollection = tblServiceDetailCollection;
    }

    @XmlTransient
    public Collection<TblServiceCart> getTblServiceCartCollection() {
        return tblServiceCartCollection;
    }

    public void setTblServiceCartCollection(Collection<TblServiceCart> tblServiceCartCollection) {
        this.tblServiceCartCollection = tblServiceCartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceTypeId != null ? serviceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServiceType)) {
            return false;
        }
        TblServiceType other = (TblServiceType) object;
        if ((this.serviceTypeId == null && other.serviceTypeId != null) || (this.serviceTypeId != null && !this.serviceTypeId.equals(other.serviceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblServiceType[ serviceTypeId=" + serviceTypeId + " ]";
    }
    
}
