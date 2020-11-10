package com.tacticforum.base;

import javax.validation.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity {

	/**
	 * 
	 */
	
	@Column(name = "pseudo")
	@NotEmpty
	private String pseudo;

	@Column(name = "email")
	@NotEmpty
	private String email;
	
	@Column(name = "password")
	@NotEmpty
	private String password;

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}