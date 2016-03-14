package com.got.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class User {

	
	private String emailId;
	private String password;
	private Date createTime;
	private Date updateTime;
	
	
	@Id
	@Column(name="USER_EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}
	
	@Column(name="USER_PASSWORD")
	public String getPassword() {
		return password;
	}
	@Column(name="USER_CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	@Column(name="USER_UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
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
	
}
