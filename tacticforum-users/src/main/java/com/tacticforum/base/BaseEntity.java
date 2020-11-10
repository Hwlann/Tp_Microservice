package com.tacticforum.base;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 2424184770260971682L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}
}
