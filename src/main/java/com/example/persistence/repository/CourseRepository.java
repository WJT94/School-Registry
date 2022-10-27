package com.example.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Course;

@Repository
@EnableJpaRepositories
public interface CourseRepository extends JpaRepository<Course, Long>
{
	// Find by id
	@Query("select c from Course c where c.id=?1")
	Course findCourseById(long id);
	
	// Find by name
	@Query("select c from Course c where c.name=?1")
	List<Course> findCourseByName(String name);

	// Find course by teacher
	@Query("select c from Course c where c.teacher=?1")
	List<Course> findCourseByTeacher(Long teacherId);
	
	// Find course by start date
	@Query("select c from Course c where c.startDate=?1")
	List<Course> findCourseByStartDate(String startDate);

	// Find course by end date
	@Query("select c from Course c where c.endDate=?1")
	List<Course> findCourseByEndDate(String endDate);
	
}
