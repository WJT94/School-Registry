package com.example.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Teacher;

@Repository
@EnableJpaRepositories
public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
	// Find by name
	@Query("SELECT t from Teacher t where t.firstName =?1 and t.lastName =?2")
	Teacher findTeacherByName(String firstName, String lastName);
	
	// Find by id
	@Query("SELECT t from Teacher t where t.id =?1")
	Teacher findTeacherById(Long id);
	
	// Find by email
	@Query("SELECT t from Teacher t where t.email =?1")
	Teacher findTeacherByEmail(String email);

	// Find by subject
	@Query("SELECT t from Teacher t where t.subject =?1")
	List<Teacher> findTeacherbySubject(String subject);
}
