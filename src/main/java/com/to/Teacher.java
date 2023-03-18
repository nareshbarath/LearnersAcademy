package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	public Teacher() {
		super();
	}

	public Teacher(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Teacher [ID=" + ID + ", name=" + name + ", email=" + email + "]";
	}

}
