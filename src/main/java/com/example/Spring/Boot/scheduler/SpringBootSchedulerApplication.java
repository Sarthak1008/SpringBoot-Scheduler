package com.example.Spring.Boot.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*
 * Step 1.) Enable Scheduling: Ensure that scheduling is enabled in your Spring
 * Boot
 * application. You can do this by adding @EnableScheduling annotation to one of
 * your configuration classes.
 */

@EnableScheduling
public class SpringBootSchedulerApplication {

	/*
	 * We do scheduling when we want a method to run repeatedly after some time or
	 * fixed interval. In such cases, the @Scheduled annotation is used.
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerApplication.class, args);
	}

}
