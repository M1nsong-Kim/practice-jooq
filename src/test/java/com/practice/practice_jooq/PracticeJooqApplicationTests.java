package com.practice.practice_jooq;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.practice_jooq.categories.Grade;
import com.practice.practice_jooq.categories.Role;
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
	
	@BeforeEach
	public void 회원주입() {
		List<Member> memberList = new ArrayList<>();
		
		Member member1 = Member.builder()
							.id("id111")
							.password("1111")
							.name("회원1")
							.idNumber("010101")
							.role(Role.USER)
							.grade(Grade.GOLD)
							.build();
		Member member2 = Member.builder()
				.id("id222")
				.password("2222")
				.name("회원2")
				.idNumber("020202")
				.role(Role.USER)
				.grade(Grade.BRONZE)
				.build();
		Member member3 = Member.builder()
				.id("id333")
				.password("3333")
				.name("회원3")
				.idNumber("030303")
				.role(Role.USER)
				.grade(Grade.BRONZE)
				.build();
		
		
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		
		for(Member m : memberList) {
			memberRepository.save(m);
		}
	}
	
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
		Assertions.assertEquals(jooqResult.size(), 4);
		
	}
	
	@Test
	public void StatsQueryTest() {
		
	}
}

