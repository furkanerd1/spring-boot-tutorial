package com.springboot.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springcore.common.Coach;

@RestController
public class DemoController {

 
	private Coach myCoach;
	private Coach anotherCoach;
	
	
	@Autowired
	public DemoController(@Qualifier("cricketCoach") Coach theCoach , @Qualifier("cricketCoach") Coach theAnotherCoach) {
		System.out.println("In Constructor : "+ getClass().getSimpleName());
		this.myCoach = theCoach;
		this.anotherCoach = theAnotherCoach;
	}



	@GetMapping("/dailyworkout")
	public String getDailyWorkOut() {
		return this.myCoach.getDailyWorkout();
	}

	
	@GetMapping("/check")
	public String check() {
		return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
	}
	//Check to see if it is same bean
	// If scope is singleton  --> it will show true
	// If scope is prototype  --> it will show false 



	
}
