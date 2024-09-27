package com.practice.practice_jooq;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.practice_jooq.member.Member;
import com.practice.practice_jooq.member.MemberDto;
import com.practice.practice_jooq.member.MemberRepository;

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
	
	@Autowired
	MemberRepository memberRepository;
	
//	@BeforeEach
//	public void 기본형주입() {
//		Member member = Member.builder
//	}
	
	@Test
	public void JpaJooqTest() {
		// given
//		Member member1 = new Member("id1", "pwd1", "user1", "971009");
		Member member2 = Member.builder()
								.id("id2")
								.password("pwd2")
								.name("user2")
								.idNumber("010101")
								.build();
//		memberRepository.save(member1);
		memberRepository.save(member2);
		

		// when
		List<MemberDto> jooqResult = memberRepository.getMemberList();
		List<Member> jpaResult = memberRepository.findAll();

		for(MemberDto m : jooqResult) {
			System.out.println(":::::::::::::: jooq :::::::::::: " + m.toString());
		}
		for(Member m : jpaResult) {
			System.out.println(":::::::::::::: jpa :::::::::::: " + m.toString());
		}
		
		// then
		Assertions.assertEquals(jooqResult.size(), 1);
		
	}
}

