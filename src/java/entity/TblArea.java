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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblArea.findAll", query = "SELECT t FROM TblArea t"),
    @NamedQuery(name = "TblArea.findByAreaId", query = "SELECT t FROM TblArea t WHERE t.areaId = :areaId"),
    @NamedQuery(name = "TblArea.findByAreaName", query = "SELECT t FROM TblArea t WHERE t.areaName = :areaName")})
public class TblArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_id")
    private Integer areaId;
    @Basic(optional = false)
    @Column(name = "area_name")
    private String areaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<TblUser> tblUserCollection;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private TblCity cityId;

    public TblArea() {
    }

    public TblArea(Integer areaId) {
        this.areaId = areaId;
    }

    public TblArea(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @XmlTransient
    public Collection<TblUser> getTblUserCollection() {
        return tblUserCollection;
    }

    public void setTblUserCollection(Collection<TblUser> tblUserCollection) {
        this.tblUserCollection = tblUserCollection;
    }

    public TblCity getCityId() {
        return cityId;
    }

    public void setCityId(TblCity cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblArea)) {
            return false;
        }
        TblArea other = (TblArea) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblArea[ areaId=" + areaId + " ]";
    }
    
}
