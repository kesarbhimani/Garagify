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
@Table(name = "tbl_feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFeedback.findAll", query = "SELECT t FROM TblFeedback t"),
    @NamedQuery(name = "TblFeedback.findByFeebackId", query = "SELECT t FROM TblFeedback t WHERE t.feebackId = :feebackId"),
    @NamedQuery(name = "TblFeedback.findByFeedback", query = "SELECT t FROM TblFeedback t WHERE t.feedback = :feedback")})
public class TblFeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "feeback_id")
    private Integer feebackId;
    @Basic(optional = false)
    @Column(name = "feedback")
    private String feedback;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private TblUser userName;

    public TblFeedback() {
    }

    public TblFeedback(Integer feebackId) {
        this.feebackId = feebackId;
    }

    public TblFeedback(Integer feebackId, String feedback) {
        this.feebackId = feebackId;
        this.feedback = feedback;
    }

    public Integer getFeebackId() {
        return feebackId;
    }

    public void setFeebackId(Integer feebackId) {
        this.feebackId = feebackId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
        hash += (feebackId != null ? feebackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFeedback)) {
            return false;
        }
        TblFeedback other = (TblFeedback) object;
        if ((this.feebackId == null && other.feebackId != null) || (this.feebackId != null && !this.feebackId.equals(other.feebackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblFeedback[ feebackId=" + feebackId + " ]";
    }
    
}
