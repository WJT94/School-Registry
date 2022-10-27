package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Teacher;
import com.example.persistence.repository.TeacherRepository;
import com.example.rest.dto.TeacherDto;
import com.example.service.TeacherService;

@SpringBootTest
public class TeacherServiceUnitTest
{
	/*
	@Autowired
	private TeacherService service;

	@MockBean
	private TeacherRepository repo;
	
	final Teacher TEST_SAVED_TEACHER = new Teacher();
	
	@Test
	void testCreate() throws Exception
	{
		final Teacher TEST_TEACHER = new Teacher(null, );
		
		given(this.repo.save(TEST_TEACHER)).willReturn(TEST_TEACHER);
		
		TeacherDto saveDto = this.service.addTeacher(TEST_TEACHER);
		
		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_TEACHER);
	}

	@Test
	void testUpdateTeacher()
	{
		given(repo.save(any(Teacher.class))).willReturn(TEST_SAVED_TEACHER);
		
		Teacher SAVED_TEACHER = repo.save(TEST_SAVED_TEACHER);
		
		assertThat(SAVED_TEACHER.getFirstName()).isNotNull();
	}
	
	@Test
	void testFindAll()
	{
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(TEST_SAVED_TEACHER);
		teachers.add(new Teacher (2L,));
		teachers.add(new Teacher (3L,));
		
		given(repo.findAll()).willReturn(teachers);
		
		List<TeacherDto> expected = service.readTeacher();
		
		assertThat(expected).usingRecursiveComparison().isEqualTo(teachers);
	}
	
	@Test
	void testFindById()
	{
		final Long id = 1L;
		final Teacher TEST_TEACHER_ID = new Teacher(1L,);
		
		given(repo.findById(id)).willReturn(Optional.of(TEST_TEACHER_ID));
		
		final TeacherDto expected = service.findById(id);
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testDeletion()
	{
		final Long id = 1L;
		
		service.deleteTeacher(id);
		service.deleteTeacher(id);
		
		verify(repo, times(2)).deleteById(id);
	}
	*/
}
