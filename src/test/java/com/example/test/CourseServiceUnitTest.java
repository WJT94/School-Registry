package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Course;
import com.example.persistence.repository.CourseRepository;
import com.example.rest.dto.CourseDto;
import com.example.service.CourseService;

@SpringBootTest
public class CourseServiceUnitTest {

	@Autowired
	private CourseService service;

	@MockBean
	private CourseRepository repo;

	final Course SAVED_COURSE = new Course(1L, "French Literature", null, "01/01/1997", "24/03/1997");

	@Test
	void testCreate() throws Exception {
		final Course TEST_COURSE = new Course();

		given(this.repo.save(TEST_COURSE)).willReturn(TEST_COURSE);

		CourseDto saveDto = this.service.addCourse(TEST_COURSE);

		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_COURSE);
	}

	@Test
	void testUpdateCourse() {
		given(repo.save(any(Course.class))).willReturn(SAVED_COURSE);

		Course TEST_SAVED_COURSE = repo.save(SAVED_COURSE);

		assertThat(TEST_SAVED_COURSE.getId()).isNotNull();
	}

	@Test
	void testFindAll() {
		List<Course> courses = new ArrayList<>();
		courses.add(SAVED_COURSE);
		courses.add(new Course());
		courses.add(new Course());

		given(repo.findAll()).willReturn(courses);

		List<CourseDto> expected = service.readCourse();

		assertThat(expected).usingRecursiveComparison().isEqualTo(courses);
	}

	@Test
	void testFindById() {
		final Long id = 1L;
		final Course TEST_COURSE_ID = new Course();

		given(repo.findById(id)).willReturn(Optional.of(TEST_COURSE_ID));

		final CourseDto expected = service.findById(id);

		assertThat(expected).isNotNull();
	}

	@Test
	void testDeletion() {
		final Long id = 1L;

		service.deleteCourse(id);
		service.deleteCourse(id);

		verify(repo, times(2)).deleteById(id);
	}

}
