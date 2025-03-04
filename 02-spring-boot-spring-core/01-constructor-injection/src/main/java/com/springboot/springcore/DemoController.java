package com.springboot.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
	private Coach myCoach;
	
	// define a constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach) {
		this.myCoach=theCoach;
	}

	
	@GetMapping("/dailyworkout")
	public String getDailyWorkOut() {
		return this.myCoach.getDailyWorkout();
	}
	
	
}
