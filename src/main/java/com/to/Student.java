package com.to;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "class_id", referencedColumnName = "ID")
	private Classes class_id;

	public Student(String name, Classes class_id) {
		super();
		this.name = name;
		this.class_id = class_id;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Classes getClass_id() {
		return class_id;
	}

	public void setClass_id(Classes class_id) {
		this.class_id = class_id;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", class_id=" + class_id + "]";
	}

}
