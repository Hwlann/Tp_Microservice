package com.tacticforum.base;

import javax.validation.constraints.NotEmpty;

public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4186900565629151337L;

	@NotEmpty
	private String pseudo;

	@NotEmpty
	private String email;
	
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