package com.example.springmapping.cruddemo.dao;

import com.example.springmapping.cruddemo.entity.Instructor;
import com.example.springmapping.cruddemo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);
}
