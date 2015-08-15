/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import com.great.cms.enums.Role;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
		@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
		@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
		@NamedQuery(name = "User.findByEnabled", query = "SELECT u FROM User u WHERE u.enabled = :enabled"),
		@NamedQuery(name = "User.findByAccountNonLocked", query = "SELECT u FROM User u WHERE u.accountNonLocked = :accountNonLocked"),
		@NamedQuery(name = "User.findByAccountNonExpired", query = "SELECT u FROM User u WHERE u.accountNonExpired = :accountNonExpired"),
		@NamedQuery(name = "User.findByCredentialsNonExpired", query = "SELECT u FROM User u WHERE u.credentialsNonExpired = :credentialsNonExpired") })
public class User implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_id")
	private Long userId;
	@Basic(optional = false)
	@Column(name = "username")
	private String username;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@Column(name = "enabled")
	private boolean enabled;
	@Basic(optional = false)
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;
	@Basic(optional = false)
	@Column(name = "account_non_expired")
	private boolean accountNonExpired;
	@Basic(optional = false)
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Student> studentList;

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Role> roles;*/

	 @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
	 @Enumerated(EnumType.STRING)
	 @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name =
	 "user_id"))
	 private List<Role> role = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Teacher> teacherList;

	public User() {
	}

	public User(Long userId) {
		this.userId = userId;
	}

	public User(Long userId, String username, String password, boolean enabled,
			boolean accountNonLocked, boolean accountNonExpired,
			boolean credentialsNonExpired) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNonLocked = accountNonLocked;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@XmlTransient
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	/*
	 * @XmlTransient public List<UserRole> getUserRoleList() { return
	 * userRoleList; }
	 * 
	 * public void setUserRoleList(List<UserRole> userRoleList) {
	 * this.userRoleList = userRoleList; }
	 */

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role= role;
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
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userId == null && other.userId != null)
				|| (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled
				+ ", accountNonLocked=" + accountNonLocked
				+ ", accountNonExpired=" + accountNonExpired
				+ ", credentialsNonExpired=" + credentialsNonExpired
				+ ", studentList=" + getStudentList() + ", userRoleList="
				+ getRole() + ", teacherList=" + getTeacherList() + "]";
	}

}
