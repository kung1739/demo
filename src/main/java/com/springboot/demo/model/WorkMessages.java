package com.springboot.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "work_messages")
public class WorkMessages implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotEmpty(message = "不可空白")
	@Size(min = 3, max = 20,message = "請輸入 3 至 20 個字")
	//@Email(message = "請輸入 Email")
	private String text;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;

	public WorkMessages() {
	}
	
	// 當 Entity 狀態要變成 Persistent 的時候，做以下方法
	@PrePersist 
	public void onCreate() {
		if(added == null) {
			added = new Date();
		}
	}
	
	@PreUpdate 
	public void onUpdate() {
//		if(added == null) {
			added = new Date();
//		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkMessages [id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append(", added=");
		builder.append(added);
		builder.append("]");
		return builder.toString();
	}
}
