package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO {
 
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
        entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
		
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager
				.createQuery("FROM Student",Student.class);
		
		return  theQuery.getResultList();

}

	@Override
	@Transactional
	public void update(Student theStudent) {
		 entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        // delete the student
        entityManager.remove(theStudent);
		
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
	   
		TypedQuery<Student> theQuery = entityManager
				.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		
		theQuery.setParameter("theData", theLastName);
		
		return theQuery.getResultList();
	}
	
}
