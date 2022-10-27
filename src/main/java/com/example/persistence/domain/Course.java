package com.example.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne(targetEntity = Teacher.class)
	@JsonBackReference
	private Teacher teacher;

	@Column
	private String startDate;

	@Column
	private String endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Course(Long id, String name, Teacher teacher, String startDate, String endDate) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Course() {
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacherid=" + teacher.getId() + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	
}
