package com.practice.practice_jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EntityScan(basePackages = "com.practice.practice_jooq.member")	// PracticeJooqApplicationTests > contextLoads() FAILED  조치였지만 해결X
public class PracticeJooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeJooqApplication.class, args);
	}

}
