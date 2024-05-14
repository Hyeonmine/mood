package com.boot.mood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
public class MoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodApplication.class, args);
	}





}
