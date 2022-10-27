package com.example.rest.dto;

import com.example.persistence.domain.Teacher;

public class CourseDto // DTOs are not entirely necessary, as no sensitive information is mapped in the
						// responses either way.
{
	private Long id;
	private String name;
	private Teacher teacher;
	private String startDate;
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

	public CourseDto(Long id, String name, Teacher teacher, String startDate, String endDate) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CourseDto() {
	}

	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", name=" + name + ", teacher=" + teacher + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
