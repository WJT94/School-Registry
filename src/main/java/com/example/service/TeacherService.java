package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TeacherNotFoundException;
import com.example.persistence.domain.Teacher;
import com.example.persistence.repository.TeacherRepository;
import com.example.rest.dto.TeacherDto;

@Service
public class TeacherService
{
	@Autowired
	private TeacherRepository repo;
	@Autowired
	private ModelMapper mapper;

	private TeacherDto mapToDTO(Teacher teacher)
	{
		return this.mapper.map(teacher, TeacherDto.class);
	}
	
//	------------------CRUD------------------
	
	// Create a teacher dto
	public TeacherDto addTeacher(Teacher teacher)
	{
		Teacher saved = this.repo.save(teacher);
		return this.mapToDTO(saved);
	}
	
	// Read all teachers
	public List<TeacherDto> readTeacher()
	{
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// Updates teacher (found by id) with new teacher data
	public TeacherDto updateTeacher(long id, Teacher teacher)
	{
		Optional<Teacher> tempTeacher = this.repo.findById(id);
		Teacher existing = tempTeacher.get();
		existing.setFirstName(teacher.getFirstName());
		existing.setLastName(teacher.getLastName());
		existing.setEmail(teacher.getEmail());
		existing.setPhone(teacher.getPhone());
		existing.setSubject(teacher.getSubject());
		Teacher updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	// Deletes teacher by ID
	public boolean deleteTeacher(long teacherId)
	{
		this.repo.deleteById(teacherId);
		boolean exists = this.repo.existsById(teacherId);
		return !exists;
	}
	
	// Finds teacher by name
	public TeacherDto findByName(String firstName, String lastName)
	{
		return mapToDTO(repo.findTeacherByName(firstName, lastName));
	}
	
	// Find teacher by ID
	public TeacherDto findById(long id)
	{
		Teacher found = this.repo.findById(id).orElseThrow(TeacherNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	// Find teacher by email
	public TeacherDto findByEmail(String email)
	{
		return mapToDTO(repo.findTeacherByEmail(email));
	}
}
