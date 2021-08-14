/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Parth Computer
 */
@Embeddable
public class TblGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;

    public TblGroupPK() {
    }

    public TblGroupPK(String groupName, String userName) {
        this.groupName = groupName;
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupName != null ? groupName.hashCode() : 0);
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGroupPK)) {
            return false;
        }
        TblGroupPK other = (TblGroupPK) object;
        if ((this.groupName == null && other.groupName != null) || (this.groupName != null && !this.groupName.equals(other.groupName))) {
            return false;
        }
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblGroupPK[ groupName=" + groupName + ", userName=" + userName + " ]";
    }
    
}
