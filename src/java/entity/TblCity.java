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
@Table(name = "tbl_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCity.findAll", query = "SELECT t FROM TblCity t"),
    @NamedQuery(name = "TblCity.findByCityId", query = "SELECT t FROM TblCity t WHERE t.cityId = :cityId"),
    @NamedQuery(name = "TblCity.findByCityName", query = "SELECT t FROM TblCity t WHERE t.cityName = :cityName")})
public class TblCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<TblArea> tblAreaCollection;

    public TblCity() {
    }

    public TblCity(Integer cityId) {
        this.cityId = cityId;
    }

    public TblCity(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<TblArea> getTblAreaCollection() {
        return tblAreaCollection;
    }

    public void setTblAreaCollection(Collection<TblArea> tblAreaCollection) {
        this.tblAreaCollection = tblAreaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCity)) {
            return false;
        }
        TblCity other = (TblCity) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblCity[ cityId=" + cityId + " ]";
    }
    
}
