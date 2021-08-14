/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Parth Computer
 */
@Entity
@Table(name = "tbl_services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServices.findAll", query = "SELECT t FROM TblServices t"),
    @NamedQuery(name = "TblServices.findByServiceId", query = "SELECT t FROM TblServices t WHERE t.serviceId = :serviceId"),
    @NamedQuery(name = "TblServices.findByTotal", query = "SELECT t FROM TblServices t WHERE t.total = :total"),
    @NamedQuery(name = "TblServices.findByDate", query = "SELECT t FROM TblServices t WHERE t.date = :date"),
    @NamedQuery(name = "TblServices.findByStatus", query = "SELECT t FROM TblServices t WHERE t.status = :status")})
public class TblServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "service_id")
    private String serviceId;
    @Basic(optional = false)
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private Collection<TblServiceDetail> tblServiceDetailCollection;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private TblUser userName;
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @ManyToOne(optional = false)
    private TblCar carId;

    public TblServices() {
    }

    public TblServices(String serviceId) {
        this.serviceId = serviceId;
    }

    public TblServices(String serviceId, float total, Date date, String status) {
        this.serviceId = serviceId;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblServiceDetail> getTblServiceDetailCollection() {
        return tblServiceDetailCollection;
    }

    public void setTblServiceDetailCollection(Collection<TblServiceDetail> tblServiceDetailCollection) {
        this.tblServiceDetailCollection = tblServiceDetailCollection;
    }

    public TblUser getUserName() {
        return userName;
    }

    public void setUserName(TblUser userName) {
        this.userName = userName;
    }

    public TblCar getCarId() {
        return carId;
    }

    public void setCarId(TblCar carId) {
        this.carId = carId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServices)) {
            return false;
        }
        TblServices other = (TblServices) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblServices[ serviceId=" + serviceId + " ]";
    }
    
}
