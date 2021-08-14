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
@Table(name = "tbl_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCompany.findAll", query = "SELECT t FROM TblCompany t"),
    @NamedQuery(name = "TblCompany.findByCompanyId", query = "SELECT t FROM TblCompany t WHERE t.companyId = :companyId"),
    @NamedQuery(name = "TblCompany.findByCompanyName", query = "SELECT t FROM TblCompany t WHERE t.companyName = :companyName")})
public class TblCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_id")
    private Integer companyId;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<TblModel> tblModelCollection;

    public TblCompany() {
    }

    public TblCompany(Integer companyId) {
        this.companyId = companyId;
    }

    public TblCompany(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @XmlTransient
    public Collection<TblModel> getTblModelCollection() {
        return tblModelCollection;
    }

    public void setTblModelCollection(Collection<TblModel> tblModelCollection) {
        this.tblModelCollection = tblModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCompany)) {
            return false;
        }
        TblCompany other = (TblCompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblCompany[ companyId=" + companyId + " ]";
    }
    
}
