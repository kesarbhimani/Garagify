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
@Table(name = "tbl_car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCar.findAll", query = "SELECT t FROM TblCar t"),
    @NamedQuery(name = "TblCar.findByCarId", query = "SELECT t FROM TblCar t WHERE t.carId = :carId"),
    @NamedQuery(name = "TblCar.findByFuelName", query = "SELECT t FROM TblCar t WHERE t.fuelName = :fuelName"),
    @NamedQuery(name = "TblCar.findByColorName", query = "SELECT t FROM TblCar t WHERE t.colorName = :colorName"),
    @NamedQuery(name = "TblCar.findByCarNo", query = "SELECT t FROM TblCar t WHERE t.carNo = :carNo")})
public class TblCar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    @Basic(optional = false)
    @Column(name = "fuel_name")
    private String fuelName;
    @Basic(optional = false)
    @Column(name = "color_name")
    private String colorName;
    @Basic(optional = false)
    @Column(name = "car_no")
    private String carNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private Collection<TblServices> tblServicesCollection;
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    @ManyToOne(optional = false)
    private TblModel modelId;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private TblUser userName;

    public TblCar() {
    }

    public TblCar(Integer carId) {
        this.carId = carId;
    }

    public TblCar(Integer carId, String fuelName, String colorName, String carNo) {
        this.carId = carId;
        this.fuelName = fuelName;
        this.colorName = colorName;
        this.carNo = carNo;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @XmlTransient
    public Collection<TblServices> getTblServicesCollection() {
        return tblServicesCollection;
    }

    public void setTblServicesCollection(Collection<TblServices> tblServicesCollection) {
        this.tblServicesCollection = tblServicesCollection;
    }

    public TblModel getModelId() {
        return modelId;
    }

    public void setModelId(TblModel modelId) {
        this.modelId = modelId;
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
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCar)) {
            return false;
        }
        TblCar other = (TblCar) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblCar[ carId=" + carId + " ]";
    }
    
}
