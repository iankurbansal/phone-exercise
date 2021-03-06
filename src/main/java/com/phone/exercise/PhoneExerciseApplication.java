package com.phone.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author Ankur Bansal
 * Entry point to phone-exercise spring boot application
 *
 */
@SpringBootApplication
//@EnableJpaRepositories("com.phone.exercise.dbRepo")
@ComponentScan(basePackages = {"com.phone.exercise.restRepo","com.phone.exercise.controller",
		"com.phone.exercise.config","com.phone.exercise.service"})
@EntityScan("com.phone.exercise.model")
public class PhoneExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneExerciseApplication.class, args);
	}
}
