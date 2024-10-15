package com.example.springmapping.cruddemo;

import com.example.springmapping.cruddemo.dao.AppDAO;
import com.example.springmapping.cruddemo.entity.Course;
import com.example.springmapping.cruddemo.entity.Instructor;
import com.example.springmapping.cruddemo.entity.InstructorDetail;
import com.example.springmapping.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			retrieveCourseAndReviews(appDAO);

		};
	}
	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 12;
		Course tempCourse = appDAO.findCourseAndReviewsById(theId);

		// print the course
		System.out.println(tempCourse.toString());

		// print the reviews
		System.out.println(tempCourse.getReviews().toString());
	}
	private void createCourseAndReviews(AppDAO appDAO) {

		//create course
		Course course = new Course("How to cook well ?");

		//addsome reviews
	    course.addReview(new Review("mükemmel"));
	   	course.addReview(new Review("it was so bad"));

		//save
		System.out.println("Saving the course with its reviews");
		appDAO.save(course);


	}
	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}
	private void deleteInstructorr(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}
	private void updateTheCourse(AppDAO appDAO){

		int theId = 10;

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.updateCourse(tempCourse);

		System.out.println("Done!");

	}
	private void updateTheInstructor(AppDAO appDAO) {

		int theId=1;

		System.out.println("Finding Instructor id : "+ theId);
		Instructor instructor = appDAO.findById(theId);

		System.out.println("Updating Instructor id : "+ theId);
		instructor.setLastName("TESTER");

		appDAO.updateInstructor(instructor);
		System.out.println("DONE !!!");

	}
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO){
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}
	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;

		System.out.println("Finding instructor id : "+ theId);

		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("tempInstructor: " + tempInstructor.getFirstName() + " " + tempInstructor.getLastName());


		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");



	}
	private void findInstructorWithCourses(AppDAO appDAO) {
          int theId=1;

		System.out.println("Finding instructor id : "+ theId);

		Instructor tempInstructor = appDAO.findById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}
	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("John","Karl","Johnk7@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com","playing guitar");

		instructor.setInstructorDetail(instructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("How to cook ?");

		instructor.addCourse(tempCourse1);
		instructor.addCourse(tempCourse2);

		appDAO.save(instructor);

	}
	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("ASD","asd","asdasd@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("video games");

		instructor.setInstructorDetail(instructorDetail);


		// save the instructor
		// NOTE : this will ALSO save the details object
		// because off CascadeType.ALL
		System.out.println("Saving Instructor: " + instructorDetail);
		appDAO.save(instructor);

		System.out.println("DONE!!!");

	}
	private void findInstructor(AppDAO appDAO) {
		 int id = 2;

		System.out.println("Finding Instructor: " + id);
		Instructor instructor = appDAO.findById(id);

		if(instructor != null) {
			System.out.println("Found Instructor: " + instructor.toString());
			System.out.println("The associate InstructorDetail only: " + instructor.getInstructorDetail());
		}else{
			System.out.println("No instructor found");
		}



	}
	private void deleteInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting Instructor: " + id);
		Instructor instructor = appDAO.findById(id);
		if(instructor != null) {
			appDAO.deleteById(instructor.getId());
			System.out.println("Deleted successfully");
		}else{
			System.out.println("No instructor found");
		}

	}
	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor detail id: "+ theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor().getFirstName());
	}
	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 5;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!!!");
	}
}
