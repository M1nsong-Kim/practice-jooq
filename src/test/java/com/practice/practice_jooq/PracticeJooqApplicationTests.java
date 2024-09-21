package com.practice.practice_jooq;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.practice_jooq.member.Member;

@SpringBootTest
class PracticeJooqApplicationTests {
	// gradle build 시 났던 오류
	/*	1. PracticeJooqApplicationTests > initializationError FAILED
	    	java.lang.IllegalStateException at Assert.java:76
	 * 	2. PracticeJooqApplicationTests > contextLoads() FAILED
		    java.lang.IllegalStateException at DefaultCacheAwareContextLoaderDelegate.java:180
		        Caused by: org.springframework.beans.factory.BeanCreationException at AbstractAutowireCapableBeanFactory.java:1806
		            Caused by: org.hibernate.AnnotationException at InheritanceState.java:279
	 */
	// 테스트 코드에 아무것도 없을 때 @SpringBootTest 어노테이션을 없애면 된다
	
	private final DSLContext dsl;

	public PracticeJooqApplicationTests(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	@Test
	public void 쿼리시험() {
		// given

		// when
		
		// then
	}
}
