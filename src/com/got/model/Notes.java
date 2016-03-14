package com.got.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="NOTES")
public class Notes {

	
	private long id;
	private String title;
	private String note;
	private Date createTime;
	private Date updateTime;
	private User notesUser;
	
	
	@Id
	public long getId() {
		return id;
	}
	
	@Column(name="NOTE_TITLE",nullable=false)
	public String getTitle() {
		return title;
	}
	
	@Column(name="NOTE_CONTENT",nullable=true)
	public String getNote() {
		return note;
	}
	@Column(name="NOTE_CREATE_TIME",nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	@Column(name="NOTE_UPDATE_TIME",nullable=true)
	public Date getUpdateTime() {
		return updateTime;
	}
	@ManyToOne
	@JoinColumn(name="USER_EMAIL_ID")
	@JsonBackReference
	public User getNotesUser() {
		return notesUser;
	}

	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	public void setNotesUser(User notesUser) {
		this.notesUser = notesUser;
	}
	
}
