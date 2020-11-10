package com.tacticforum.comments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.tacticforum.base.BaseEntity;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

	@Column(name = "author")
	@NotEmpty
	private String author;

	@Column(name = "date")
	@NotEmpty
	private String date;

	@Column(name = "time")
	@NotEmpty
	private String time;

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
