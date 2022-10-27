package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rest.controller.TeacherController;

@SpringBootTest
public class TeacherRestControllerTest 
{
	@Autowired
	private TeacherController controller;
	
	@Test
	public void controllerHasInitialised() // Checks that the REST controller has been initialised
	{
		assertThat(controller).isNotNull();
	}
}
