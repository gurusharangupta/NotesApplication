package com.got.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="USER_DETAILS")
public class User {

	
	private String emailId;
	private String password;
	private Date createTime;
	private Date updateTime;
	private List<Notes> userNotes = new ArrayList<Notes>();
	
	
	@Id
	@Column(name="USER_EMAIL_ID",nullable=false)
	public String getEmailId() {
		return emailId;
	}
	
	@Column(name="USER_PASSWORD",nullable=false)
	public String getPassword() {
		return password;
	}
	@Column(name="USER_CREATE_TIME",nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	@Column(name="USER_UPDATE_TIME",nullable=true)
	public Date getUpdateTime() {
		return updateTime;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="notesUser")
	@JsonManagedReference
	public List<Notes> getUserNotes() {
		return userNotes;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public void setUserNotes(List<Notes> userNotes) {
		this.userNotes = userNotes;
	}
	
}
