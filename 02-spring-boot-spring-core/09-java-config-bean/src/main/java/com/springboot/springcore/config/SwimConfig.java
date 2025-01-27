package com.springboot.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.springcore.common.Coach;
import com.springboot.springcore.common.SwimCoach;

@Configuration
public class SwimConfig {

	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
