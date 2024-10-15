package com.springboot.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springcore.common.Coach;

@RestController
public class DemoController {

    // define a private field for the dependency
	private Coach myCoach;
	
	// define a constructor for setter injection
    @Autowired
	public void setMyCoach(Coach myCoach) {
		this.myCoach = myCoach;
	}
	

	
	@GetMapping("/dailyworkout")
	public String getDailyWorkOut() {
		return this.myCoach.getDailyWorkout();
	}



	
}
