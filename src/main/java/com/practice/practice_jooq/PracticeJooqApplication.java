package com.practice.practice_jooq;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EntityScan(basePackages = "com.practice.practice_jooq.member")	// PracticeJooqApplicationTests > contextLoads() FAILED  조치였지만 해결X
public class PracticeJooqApplication {
	
//	@Bean
//	public DefaultDSLContext dsl(org.jooq.Configuration config) {
//		return new DefaultDSLContext(config);
//	}

	public static void main(String[] args) {
		SpringApplication.run(PracticeJooqApplication.class, args);
	}

}
