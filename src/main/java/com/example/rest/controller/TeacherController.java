package com.example.rest.controller;

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

import com.example.persistence.domain.Teacher;
import com.example.rest.dto.TeacherDto;
import com.example.service.TeacherService;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
	@Autowired
	private TeacherService service;

	public TeacherController(TeacherService service) {
		super();
		this.service = service;
	}

	// Create a teacher dto
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TeacherDto create(@RequestBody Teacher teacher) {
		return this.service.addTeacher(teacher);
	}

	// Read all teachers
	@GetMapping("/read")
	public List<TeacherDto> readAll() {
		return this.service.readTeacher();
	}

	// Read teacher by first and last name
	@GetMapping("/readname/{firstName}/{lastName}")
	public TeacherDto readByName(@PathVariable String firstName, @PathVariable String lastName) {
		return this.service.findByName(firstName, lastName);
	}

	// Read teacher, found by id
	@GetMapping("/readid/{id}")
	public TeacherDto readById(@PathVariable long id) {
		return this.service.findById(id);
	}

	// Read by email
	@GetMapping("/reademail/{email}")
	public TeacherDto readByEmail(@PathVariable String email) {
		return this.service.findByEmail(email);
	}

	// UPDATE USER
	@PutMapping("/update/{id}")
	public TeacherDto update(@PathVariable long id, @RequestBody Teacher teacher) {
		return this.service.updateTeacher(id, teacher);
	}

	// Deletes teacher by id.
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		this.service.deleteTeacher(id);
	}
}
