package com.practice.practice_jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@SpringBootApplication
// @EntityScan(basePackages = "com.practice.practice_jooq.member")	// PracticeJooqApplicationTests > contextLoads() FAILED  조치였지만 해결X
@EnableJpaAuditing 	// create dtm, update dtm은 JPA에서 기본적으로 제공(auditing 사용하려면 필수)
public class PracticeJooqApplication {
	
//	@Bean
//	public DefaultDSLContext dsl(org.jooq.Configuration config) {
//		return new DefaultDSLContext(config);
//	}

	public static void main(String[] args) {
		SpringApplication.run(PracticeJooqApplication.class, args);
	}

}
