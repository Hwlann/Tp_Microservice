package com.tacticforum.base;

public class NamedEntity extends BaseEntity {

	private static final long serialVersionUID = 2446188756314477812L;
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
