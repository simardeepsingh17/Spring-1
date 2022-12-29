package com.practice.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	
	private final StudentRepository studentRepository ;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	public List<Student> getStudents(){
		return studentRepository.findAll();
	}



	public Student addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentbyEmail(student.getEmail());
		
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		Student studentobj = studentRepository.save(student);
		return studentobj;
	}



	public void deleteStudent(int id) {
		
	boolean exists= studentRepository.existsById((long) id);
		if(!exists) {
			
		}
		studentRepository.deleteById((long) id);
	}
}
