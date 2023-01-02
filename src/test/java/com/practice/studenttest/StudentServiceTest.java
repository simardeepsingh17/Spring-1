package com.practice.studenttest;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
//
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.demo2.Demo2Application;
import com.practice.demo2.beans.Student;
import com.practice.demo2.repository.StudentRepository;
import com.practice.demo2.service.StudentService;

import static org.junit.Assert.assertEquals;
//import org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

@SpringBootTest(classes = Demo2Application.class)
public class StudentServiceTest {

	@InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repo;
  
    
    
    @Test
    public void addNewStudentTest() {
    	Student student = new Student();
		
		when(repo.save(student)).thenReturn(student);
		assertEquals(student, studentService.addNewStudent(student));
    }
    
    @Test
	public void getStudentsTest() {
		Student Student = new Student(1,"alex","alex@gmail",LocalDate.of(1990, 05, 17) );
		Student Student1 = new Student(2,"alex","alex@gmail",LocalDate.of(1990, 05, 17) );
		List<Student> list = new ArrayList<Student>();
		list.add(Student);
		list.add(Student1);

		when(repo.findAll()).thenReturn(list);
		assertEquals(2, studentService.getStudents().size());
	}
    
   
   
       

}
