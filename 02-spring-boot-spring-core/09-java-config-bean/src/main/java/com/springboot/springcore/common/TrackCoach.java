package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	public TrackCoach() {
		System.out.println("In Constructor : "+ getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}

}
