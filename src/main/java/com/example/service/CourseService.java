package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CourseNotFoundException;
import com.example.persistence.domain.Course;
import com.example.persistence.repository.CourseRepository;
import com.example.rest.dto.CourseDto;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repo;
	@Autowired
	private ModelMapper mapper;

	private CourseDto mapToDTO(Course course) {
		return this.mapper.map(course, CourseDto.class);
	}

	// Creates a course DTO.
	public CourseDto addCourse(Course course) {
		Course saved = this.repo.save(course);
		return this.mapToDTO(saved);
	}

	// Read all
	public List<CourseDto> readCourse() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Update course (found by id) with new course data.
	public CourseDto updateCourse(Long courseId, Course course) {
		Optional<Course> tempAcc = this.repo.findById(courseId);

		Course existing = tempAcc.get();

		existing.setName(course.getName());
		existing.setTeacher(course.getTeacher());
		existing.setStartDate(course.getStartDate());
		existing.setEndDate(course.getEndDate());

		Course updated = this.repo.save(existing);

		return this.mapToDTO(updated);
	}

	// Delete course (found by id)
	public boolean deleteCourse(Long courseId) {
		this.repo.deleteById(courseId);
		boolean exists = this.repo.existsById(courseId);
		return !exists;
	}

	// Find by course id
	public CourseDto findById(Long id) {
		Course found = this.repo.findById(id).orElseThrow(CourseNotFoundException::new);
		return this.mapToDTO(found);
	}

	public List<CourseDto> findByTeacher(Long teacherId) {
		List<Course> found = this.repo.findCourseByTeacher(teacherId);
		List<CourseDto> foundDto = new ArrayList<>();
		for (Course c : found) {
			foundDto.add(this.mapToDTO(c));
		}
		return foundDto;
	}

	
	// Find by course start date
	public List<CourseDto> findByStartDate(String startDate) {
		List<Course> found = this.repo.findCourseByStartDate(startDate);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Find by course end date
	public List<CourseDto> findByEndDate(String endDate) {
		List<Course> found = this.repo.findCourseByEndDate(endDate);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
}
