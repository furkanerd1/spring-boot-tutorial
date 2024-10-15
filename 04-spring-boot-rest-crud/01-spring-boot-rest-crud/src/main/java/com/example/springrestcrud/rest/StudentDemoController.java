package com.example.springrestcrud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestcrud.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentDemoController {

	List<Student> studentList;
	
	 // define @PostConstruct to load the student data ... only once!
	
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<>();
		
		studentList.add(new Student("Jack","Oriel"));
		studentList.add(new Student("Bob","Oriel"));
		studentList.add(new Student("Martin","Oriel"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return studentList.get(studentId);
	}
	
}
