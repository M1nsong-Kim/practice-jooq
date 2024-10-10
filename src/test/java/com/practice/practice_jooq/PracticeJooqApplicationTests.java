package com.practice.practice_jooq;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.practice_jooq.categories.Category;
import com.practice.practice_jooq.categories.Grade;
import com.practice.practice_jooq.categories.Role;
import com.practice.practice_jooq.categories.Status;
import com.practice.practice_jooq.categories.TextSearchWildcard;
import com.practice.practice_jooq.categories.TimePeriod;
import com.practice.practice_jooq.member.Member;
import com.practice.practice_jooq.member.MemberDto;
import com.practice.practice_jooq.member.MemberRepository;
import com.practice.practice_jooq.product.Product;
import com.practice.practice_jooq.product.ProductRepository;
import com.practice.practice_jooq.purchase.Purchase;
import com.practice.practice_jooq.purchase.PurchaseRepository;
import com.practice.practice_jooq.stats.RankDto;
import com.practice.practice_jooq.stats.StatsDto;
import com.practice.practice_jooq.stats.StatsRepository;

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
	
	@Autowired MemberRepository memberRepository;
	@Autowired ProductRepository productRepository;
	@Autowired PurchaseRepository purchaseRepository;
	@Autowired StatsRepository statsRepository;
	
	@BeforeEach
	public void 회원_상품_구매_주입() {
		List<Member> memberList = new ArrayList<>();
		
		Member member1 = Member.builder()
							.id("id111")
							.password("1111")
							.name("회원1")
							.gender(1)
							.idNumber("010101")
							.role(Role.USER)
							.grade(Grade.GOLD)
							.build();
		Member member2 = Member.builder()
				.id("id222")
				.password("2222")
				.name("회원2")
				.gender(2)
				.idNumber("020202")
				.role(Role.USER)
				.grade(Grade.BRONZE)
				.build();
		Member member3 = Member.builder()
				.id("id333")
				.password("3333")
				.name("회원3")
				.gender(2)
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
		
		Product product1 = Product.builder()
				.id("S01")
				.category(Category.SKIRTS)
				.name("치마1")
				.price(35000)
				.build();

		Product product2 = Product.builder()
						.id("S02")
						.category(Category.SKIRTS)
						.name("치마2")
						.price(40000)
						.build();
		
		Product product3 = Product.builder()
				.id("P01")
				.category(Category.PANTS)
				.name("바지1")
				.price(40000)
				.build();
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		Purchase purchase1 = Purchase.builder()
						.purchaseId(1)
						.memberId("id111")
						.productId("S01")
						.count(1)
						.status(Status.Completed)
						.build();
		
		Purchase purchase2 = Purchase.builder()
						.purchaseId(2)
						.memberId("id222")
						.productId("S01")
						.count(3)
						.status(Status.Completed)
						.build();
		
		Purchase purchase3 = Purchase.builder()
						.purchaseId(3)
						.memberId("id111")
						.productId("P01")
						.count(1)
						.status(Status.Completed)
						.build();
		purchaseRepository.save(purchase1);
		purchaseRepository.save(purchase2);
		purchaseRepository.save(purchase3);
	}
	
	@Test @Disabled
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
	
	@Test @Disabled
	public void StatsQueryTest() {
		// given
		
		// when
		List<StatsDto> categoryResult = statsRepository.selectStatsSalesByCategory();
		List<StatsDto> genderResult = statsRepository.selectStatsSalesByGender();
			
		// then
		System.out.println("********************* " + categoryResult);
		System.out.println("********************* " + genderResult);
	}
	
	// 순위
	@Test
	public void 순위테스트() {
		// given
		
		// when
		List<RankDto> result = statsRepository.selectRankSalesByAll(TimePeriod.NONE, "PANTS");
		
		// then
		System.out.println("********************* " + result);
	}
}


