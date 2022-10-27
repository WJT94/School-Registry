package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.persistence.domain.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherServiceIntegrationTest
{
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private final Teacher TEST_TEACHER = new Teacher(1L, "John", "Smith", "jsmith123@gmail.com", "1234567890", "Literature", null);
	
	@Test
	public void testCreateTeacher() throws Exception
	{
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/teacher/create");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.objectMapper.writeValueAsString(TEST_TEACHER));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		
		this.mock
			.perform(mockRequest)
			.andExpect(matchStatus);
	}
	
}
