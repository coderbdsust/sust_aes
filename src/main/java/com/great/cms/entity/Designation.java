/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;
import java.util.List;
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
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "designation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Designation.findAll", query = "SELECT d FROM Designation d"),
    @NamedQuery(name = "Designation.findByDesigId", query = "SELECT d FROM Designation d WHERE d.desigId = :desigId"),
    @NamedQuery(name = "Designation.findByDesigName", query = "SELECT d FROM Designation d WHERE d.desigName = :desigName"),
    @NamedQuery(name = "Designation.findByDesigDesc", query = "SELECT d FROM Designation d WHERE d.desigDesc = :desigDesc")})
public class Designation implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desig_id")
    private Integer desigId;
    @Basic(optional = false)
    @Column(name = "desig_name")
    private String desigName;
    @Column(name = "desig_desc")
    private String desigDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desigId")
    private List<Teacher> teacherList;

    public Designation() {
    }

    public Designation(Integer desigId) {
        this.desigId = desigId;
    }

    public Designation(Integer desigId, String desigName) {
        this.desigId = desigId;
        this.desigName = desigName;
    }

    public Integer getDesigId() {
        return desigId;
    }

    public void setDesigId(Integer desigId) {
        this.desigId = desigId;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
    }

    public String getDesigDesc() {
        return desigDesc;
    }

    public void setDesigDesc(String desigDesc) {
        this.desigDesc = desigDesc;
    }

    @XmlTransient
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desigId != null ? desigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Designation)) {
            return false;
        }
        Designation other = (Designation) object;
        if ((this.desigId == null && other.desigId != null) || (this.desigId != null && !this.desigId.equals(other.desigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.greatcms.cms.entity.Designation[ desigId=" + desigId + " ]";
    }
    
}
