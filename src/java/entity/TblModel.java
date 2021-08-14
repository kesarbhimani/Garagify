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
@Table(name = "tbl_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblModel.findAll", query = "SELECT t FROM TblModel t"),
    @NamedQuery(name = "TblModel.findByModelId", query = "SELECT t FROM TblModel t WHERE t.modelId = :modelId"),
    @NamedQuery(name = "TblModel.findByModelName", query = "SELECT t FROM TblModel t WHERE t.modelName = :modelName")})
public class TblModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_id")
    private Integer modelId;
    @Basic(optional = false)
    @Column(name = "model_name")
    private String modelName;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @ManyToOne(optional = false)
    private TblCompany companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelId")
    private Collection<TblCar> tblCarCollection;

    public TblModel() {
    }

    public TblModel(Integer modelId) {
        this.modelId = modelId;
    }

    public TblModel(Integer modelId, String modelName) {
        this.modelId = modelId;
        this.modelName = modelName;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public TblCompany getCompanyId() {
        return companyId;
    }

    public void setCompanyId(TblCompany companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public Collection<TblCar> getTblCarCollection() {
        return tblCarCollection;
    }

    public void setTblCarCollection(Collection<TblCar> tblCarCollection) {
        this.tblCarCollection = tblCarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblModel)) {
            return false;
        }
        TblModel other = (TblModel) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblModel[ modelId=" + modelId + " ]";
    }
    
}
