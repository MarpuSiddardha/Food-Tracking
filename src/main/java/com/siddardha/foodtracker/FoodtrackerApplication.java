package com.siddardha.foodtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FoodtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodtrackerApplication.class, args);
	}

}
