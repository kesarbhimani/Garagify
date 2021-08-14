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
@Table(name = "tbl_service_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServiceDetail.findAll", query = "SELECT t FROM TblServiceDetail t"),
    @NamedQuery(name = "TblServiceDetail.findBySdetailId", query = "SELECT t FROM TblServiceDetail t WHERE t.sdetailId = :sdetailId"),
    @NamedQuery(name = "TblServiceDetail.findByStatus", query = "SELECT t FROM TblServiceDetail t WHERE t.status = :status")})
public class TblServiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sdetail_id")
    private Integer sdetailId;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    @ManyToOne(optional = false)
    private TblServiceType serviceTypeId;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private TblServices serviceId;

    public TblServiceDetail() {
    }

    public TblServiceDetail(Integer sdetailId) {
        this.sdetailId = sdetailId;
    }

    public TblServiceDetail(Integer sdetailId, String status) {
        this.sdetailId = sdetailId;
        this.status = status;
    }

    public Integer getSdetailId() {
        return sdetailId;
    }

    public void setSdetailId(Integer sdetailId) {
        this.sdetailId = sdetailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TblServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(TblServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public TblServices getServiceId() {
        return serviceId;
    }

    public void setServiceId(TblServices serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdetailId != null ? sdetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServiceDetail)) {
            return false;
        }
        TblServiceDetail other = (TblServiceDetail) object;
        if ((this.sdetailId == null && other.sdetailId != null) || (this.sdetailId != null && !this.sdetailId.equals(other.sdetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblServiceDetail[ sdetailId=" + sdetailId + " ]";
    }
    
}
