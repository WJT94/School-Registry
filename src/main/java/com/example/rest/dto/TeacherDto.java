package com.example.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.persistence.domain.Course;

public class TeacherDto // DTOs are not entirely necessary, as no sensitive information is mapped in the
						// responses either way.
{
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String subject;
	
	private List<Course> courses = new ArrayList<>();

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public TeacherDto(String firstName, String lastName, String email, String phone, String subject,
			List<Course> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.subject = subject;
		this.courses = courses;
	}

	public TeacherDto() {
	}

	@Override
	public String toString() {
		return "TeacherDto [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", subject=" + subject + ", courses=" + courses + "]";
	}

}
