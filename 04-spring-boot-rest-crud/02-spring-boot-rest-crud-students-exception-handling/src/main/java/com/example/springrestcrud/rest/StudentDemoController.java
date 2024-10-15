package com.example.springrestcrud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		return studentList; // Jackson will convert to JSON
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		if(studentId>studentList.size() || studentId<0) {
			throw new StudentNotFoundException("Student id is not found " +studentId);
		}
		
		return studentList.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
	
		// create a studentErrorResponse 
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponeEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	// add another exception handler ... to catch any exception (catch all)
	// if input is string or smthing.

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
}
