/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tbl_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGroup.findAll", query = "SELECT t FROM TblGroup t"),
    @NamedQuery(name = "TblGroup.findByGroupName", query = "SELECT t FROM TblGroup t WHERE t.tblGroupPK.groupName = :groupName"),
    @NamedQuery(name = "TblGroup.findByUserName", query = "SELECT t FROM TblGroup t WHERE t.tblGroupPK.userName = :userName")})
public class TblGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblGroupPK tblGroupPK;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblUser tblUser;

    public TblGroup() {
    }

    public TblGroup(TblGroupPK tblGroupPK) {
        this.tblGroupPK = tblGroupPK;
    }

    public TblGroup(String groupName, String userName) {
        this.tblGroupPK = new TblGroupPK(groupName, userName);
    }

    public TblGroupPK getTblGroupPK() {
        return tblGroupPK;
    }

    public void setTblGroupPK(TblGroupPK tblGroupPK) {
        this.tblGroupPK = tblGroupPK;
    }

    public TblUser getTblUser() {
        return tblUser;
    }

    public void setTblUser(TblUser tblUser) {
        this.tblUser = tblUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblGroupPK != null ? tblGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGroup)) {
            return false;
        }
        TblGroup other = (TblGroup) object;
        if ((this.tblGroupPK == null && other.tblGroupPK != null) || (this.tblGroupPK != null && !this.tblGroupPK.equals(other.tblGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblGroup[ tblGroupPK=" + tblGroupPK + " ]";
    }
    
}
