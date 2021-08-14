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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findByUserId", query = "SELECT t FROM TblUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblUser.findByUserName", query = "SELECT t FROM TblUser t WHERE t.userName = :userName"),
    @NamedQuery(name = "TblUser.findByPassword", query = "SELECT t FROM TblUser t WHERE t.password = :password"),
    @NamedQuery(name = "TblUser.findByFirstName", query = "SELECT t FROM TblUser t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TblUser.findByLastName", query = "SELECT t FROM TblUser t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TblUser.findByEmail", query = "SELECT t FROM TblUser t WHERE t.email = :email"),
    @NamedQuery(name = "TblUser.findByPhoneNo", query = "SELECT t FROM TblUser t WHERE t.phoneNo = :phoneNo"),
    @NamedQuery(name = "TblUser.findByAddress", query = "SELECT t FROM TblUser t WHERE t.address = :address"),
    @NamedQuery(name = "TblUser.findByJoinningDate", query = "SELECT t FROM TblUser t WHERE t.joinningDate = :joinningDate"),
    @NamedQuery(name = "TblUser.findByStatus", query = "SELECT t FROM TblUser t WHERE t.status = :status")})
public class TblUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Id
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone_no")
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "joinning_date")
    @Temporal(TemporalType.DATE)
    private Date joinningDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<TblRating> tblRatingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<TblFeedback> tblFeedbackCollection;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(optional = false)
    private TblArea areaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUser")
    private Collection<TblGroup> tblGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<TblServiceCart> tblServiceCartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<TblServices> tblServicesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<TblCar> tblCarCollection;

    public TblUser() {
    }

    public TblUser(String userName) {
        this.userName = userName;
    }

    public TblUser(String userName, int userId, String password, String firstName, String lastName, String email, String phoneNo, String address, Date joinningDate, String status) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.joinningDate = joinningDate;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoinningDate() {
        return joinningDate;
    }

    public void setJoinningDate(Date joinningDate) {
        this.joinningDate = joinningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblRating> getTblRatingCollection() {
        return tblRatingCollection;
    }

    public void setTblRatingCollection(Collection<TblRating> tblRatingCollection) {
        this.tblRatingCollection = tblRatingCollection;
    }

    @XmlTransient
    public Collection<TblFeedback> getTblFeedbackCollection() {
        return tblFeedbackCollection;
    }

    public void setTblFeedbackCollection(Collection<TblFeedback> tblFeedbackCollection) {
        this.tblFeedbackCollection = tblFeedbackCollection;
    }

    public TblArea getAreaId() {
        return areaId;
    }

    public void setAreaId(TblArea areaId) {
        this.areaId = areaId;
    }

    @XmlTransient
    public Collection<TblGroup> getTblGroupCollection() {
        return tblGroupCollection;
    }

    public void setTblGroupCollection(Collection<TblGroup> tblGroupCollection) {
        this.tblGroupCollection = tblGroupCollection;
    }

    @XmlTransient
    public Collection<TblServiceCart> getTblServiceCartCollection() {
        return tblServiceCartCollection;
    }

    public void setTblServiceCartCollection(Collection<TblServiceCart> tblServiceCartCollection) {
        this.tblServiceCartCollection = tblServiceCartCollection;
    }

    @XmlTransient
    public Collection<TblServices> getTblServicesCollection() {
        return tblServicesCollection;
    }

    public void setTblServicesCollection(Collection<TblServices> tblServicesCollection) {
        this.tblServicesCollection = tblServicesCollection;
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
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblUser[ userName=" + userName + " ]";
    }
    
}
