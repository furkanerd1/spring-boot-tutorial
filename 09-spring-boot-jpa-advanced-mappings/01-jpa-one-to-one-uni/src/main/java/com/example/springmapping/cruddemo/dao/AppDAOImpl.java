package com.example.springmapping.cruddemo.dao;

import com.example.springmapping.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class AppDAOImpl implements AppDAO {

   private final EntityManager entityManager;


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
          entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        Instructor  theInstructor = entityManager.find(Instructor.class, theId);
        return theInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
       Instructor instructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(instructor);


    }
}
