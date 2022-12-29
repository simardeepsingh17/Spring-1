package com.practice.studenttest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;

import org.springframework.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.demo2.Demo2Application;
import com.practice.demo2.student.Student;
import com.practice.demo2.student.StudentController;
import com.practice.demo2.student.StudentRepository;
import com.practice.demo2.student.StudentService;


@SpringBootTest(classes = Demo2Application.class)
class StudentControllerTest extends Demo2ApplicationTests{

	

	@InjectMocks
	private StudentController controller;

	@Mock
	private StudentService service;


	private MockMvc mockMvc;
	
	 @BeforeEach
	    public void before() {
	        MockitoAnnotations.openMocks(this);
	        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	    }

	 	@Test
    	void addNewStudentTests() throws Exception {
		
        Integer id = 1;
        Student student = new Student();
        student.setId(id);
        student.setEmail("test@xyz");
        Mockito.when(service.addNewStudent(student)).thenReturn(student);
        String inputJson = super.mapToJson(student);         
        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders
                 .post("/api/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson)) 
                .andReturn();    
        String content = mvcResult.getResponse().getContentAsString();
        Assert.notNull(content);
  
    }
	 	


}
