package com.example.springmapping.cruddemo.dao;

import com.example.springmapping.cruddemo.entity.Course;
import com.example.springmapping.cruddemo.entity.Instructor;
import com.example.springmapping.cruddemo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor  tempInstructor);

    void updateCourse(Course tempCourse);

    Course findCourseById(int theId);

    void deleteInstructorById(int theId);

    void deleteCourseById(int theId);
}
