package com.tacticforum.post;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "posts")
public class Post {
	
	// ------------------------------------------------------------ VARIABLES 
	@Column(name = "content")
	@NotEmpty
	private String content;
	
	@Column(name = "title")
	@NotEmpty
	private String title;
	
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;
	
	private Integer userId;	
	@Transient
	private HashSet<Integer> comments = new LinkedHashSet<>();
	
	// ------------------------------------------------------------ GETTERS SETTERS 

	
	// ------------------------------------------------------------ DATE 
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getreateDate() {
		return this.createDate;
	}
	
	// ------------------------------------------------------------ CONTENT 
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	// ------------------------------------------------------------ TITLE 
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// ------------------------------------------------------------ COMMENTS 
	public HashSet<Integer> getVisits() {
		if (this.comments == null) {
			this.comments = new HashSet<>();
		}
		return this.comments;
	}

	public void addVisit(Integer comments) {
		getVisits().add(comments);
	}
	
	// ------------------------------------------------------------ USERID 
	public Integer getUser() {
		return this.userId;
	}

	public void setUser(Integer user) {
		this.userId = user;
	}

}
