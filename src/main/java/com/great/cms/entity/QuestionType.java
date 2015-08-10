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
@Table(name = "question_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionType.findAll", query = "SELECT q FROM QuestionType q"),
    @NamedQuery(name = "QuestionType.findByQuestionTypeId", query = "SELECT q FROM QuestionType q WHERE q.questionTypeId = :questionTypeId"),
    @NamedQuery(name = "QuestionType.findByQuestionTypeName", query = "SELECT q FROM QuestionType q WHERE q.questionTypeName = :questionTypeName")})
public class QuestionType implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "question_type_id")
    private Long questionTypeId;
    @Basic(optional = false)
    @Column(name = "question_type_name")
    private String questionTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionTypeId")
    private List<Questions> questionsList;

    public QuestionType() {
    }

    public QuestionType(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public QuestionType(Long questionTypeId, String questionTypeName) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    @XmlTransient
    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionTypeId != null ? questionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionType)) {
            return false;
        }
        QuestionType other = (QuestionType) object;
        if ((this.questionTypeId == null && other.questionTypeId != null) || (this.questionTypeId != null && !this.questionTypeId.equals(other.questionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.greatcms.cms.entity.QuestionType[ questionTypeId=" + questionTypeId + " ]";
    }
    
}
