package com.example.springmapping.cruddemo.dao;

import com.example.springmapping.cruddemo.entity.Course;
import com.example.springmapping.cruddemo.entity.Instructor;
import com.example.springmapping.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.TabExpander;
import java.util.List;

@Repository
@AllArgsConstructor
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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery("FROM Course where instructor.id = :data ", Course.class);
        query.setParameter("data", theId);

        return query.getResultList();

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> instructorTypedQuery = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);

         instructorTypedQuery.setParameter("data", theId);
         return instructorTypedQuery.getSingleResult();

    }

    @Override
    @Transactional
    public void updateInstructor(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        Course theCourse = entityManager.find(Course.class, theId);
        return theCourse;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
       Instructor instructor = entityManager.find(Instructor.class, theId);
       List<Course> courses = instructor.getCourses();

       if(!(courses.isEmpty())){

           for(Course course : courses){
               course.setInstructor(null);
           }
       }

       entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course theCourse = entityManager.find(Course.class, theId);
        entityManager.remove(theCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
       entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsById(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                " select c from Course c "
                +"JOIN FETCH c.reviews"
                + " where c.id = :data",Course.class);

        query.setParameter("data", theId);
        return query.getSingleResult();
    }
}
