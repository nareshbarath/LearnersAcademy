package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "STD")
	private String std;

	@Column(name = "Section")
	private String section;

	public Classes() {
		super();
	}

	public Classes(String std, String section) {
		super();
		this.std = std;
		this.section = section;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Classes [ID=" + ID + ", std=" + std + ", section=" + section + "]";
	}

}
