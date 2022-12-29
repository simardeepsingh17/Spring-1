package com.practice.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

	
	private final StudentService studentservice ;
	
	
	@Autowired
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}



//	@GetMapping(path = "/api")
//	public List<Student> getSudents(){
//		return studentservice.getStudents();
//		
//	}
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return studentservice.getStudents();
		
	}
	
	@PostMapping(path ="/api/student", consumes = "application/json")
	public  ResponseEntity<Student> registerNewStudent(@RequestBody Student student) {
		return new ResponseEntity<Student> (studentservice.addNewStudent(student),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/api/{studentId}")
	public void deleteStudent(@PathVariable("studentId")int id) {
		
		studentservice.deleteStudent(id);
	}
	
}
