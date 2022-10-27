package com.example.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Course;
import com.example.rest.dto.CourseDto;
import com.example.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
	@Autowired
	CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}

	// Create course
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CourseDto create(@RequestBody Course course) {
		return this.service.addCourse(course);
	}

	// Read all courses
	@GetMapping("/read")
	public List<CourseDto> readAll() {
		return this.service.readCourse();
	}

	// Read course by id
	@GetMapping("/readid/{id}")
	public CourseDto readById(@PathVariable Long id) {
		return this.service.findById(id);
	}

	// Read course by start date
	@GetMapping("/readstartdate/{startDate}")
	public List<CourseDto> readByStartDate(@PathVariable String startDate) {
		return this.service.findByStartDate(startDate);
	}

	// Read course by end date
	@GetMapping("/readenddate/{endDate}")
	public List<CourseDto> readByEndDate(@PathVariable String endDate) {
		return this.service.findByStartDate(endDate);
	}

	// Read course by teacher
	@GetMapping("/readbyteacher/{id}")
	public List<CourseDto> readByTeacher(@PathVariable Long id) {
		List<CourseDto> found = new ArrayList<CourseDto>();
		for (CourseDto c : this.service.readCourse()) {
			if (c.getTeacher().getId().equals(id)) {
				found.add(c);
			}
		}
		return found;
	}

	// Update course (found by id) with new course data
	@PutMapping("/update/{id}")
	public CourseDto update(@PathVariable Long id, @RequestBody Course course) {
		return this.service.updateCourse(id, course);
	}

	// Delete course by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.service.deleteCourse(id);
	}
}
