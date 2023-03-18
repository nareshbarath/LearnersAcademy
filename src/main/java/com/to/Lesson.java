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
@Table(name = "Lesson")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "class_id", referencedColumnName = "ID")
	private Classes class_id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "subject_id", referencedColumnName = "ID")
	private Subject subject_id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "teacher_id", referencedColumnName = "ID")
	private Teacher teacher_id;

	public Classes getClass_id() {
		return class_id;
	}

	public void setClass_id(Classes class_id) {
		this.class_id = class_id;
	}

	public Subject getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}

	public Teacher getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Teacher teacher_id) {
		this.teacher_id = teacher_id;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Lesson [ID=" + ID + ", class_id=" + class_id + ", subject_id=" + subject_id + ", teacher_id="
				+ teacher_id + "]";
	}

	public Lesson(Classes class_id, Subject subject_id, Teacher teacher_id) {
		super();
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
	}

	public Lesson() {
		super();
	}
}
