package com.example.springmapping.cruddemo;

import com.example.springmapping.cruddemo.dao.AppDAO;
import com.example.springmapping.cruddemo.entity.Instructor;
import com.example.springmapping.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	public void createInstructor(AppDAO appDAO) {

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

	public void findInstructor(AppDAO appDAO) {
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

	public void deleteInstructor(AppDAO appDAO) {
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
}
