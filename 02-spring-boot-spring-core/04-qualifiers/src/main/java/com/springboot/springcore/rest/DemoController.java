package com.springboot.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springcore.common.Coach;

@RestController
public class DemoController {

 
	private Coach myCoach;
	
	
	//In the qualifier -->  same as name of class but  first character lower-case
	@Autowired
	public DemoController(@Qualifier("trackCoach") Coach theCoach) {
		this.myCoach = theCoach;
	}



	@GetMapping("/dailyworkout")
	public String getDailyWorkOut() {
		return this.myCoach.getDailyWorkout();
	}



	
}
