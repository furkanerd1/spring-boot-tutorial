package com.springboot.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springcore.common.Coach;

@RestController
public class DemoController {


	private Coach myCoach;
	

	@Autowired
	public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
		System.out.println("In Constructor : "+ getClass().getSimpleName());
		this.myCoach = theCoach;
		
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkOut() {
		return this.myCoach.getDailyWorkout();
	}



	
}
