package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(int id);
	
	List<Student> findAll();
	
	void update(Student theStudent);
	
    void delete(Integer id);
    
    List<Student> findByLastName(String theLastName);
}
