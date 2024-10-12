package com.practice.practice_jooq.product;

import com.practice.practice_jooq.base.BaseEntity;
import com.practice.practice_jooq.categories.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
//Builder 사용 시 불필요 @RequiredArgsConstructor
@ToString
@NoArgsConstructor // 기본 생성자를 생성(둘중 하나만 쓰면 @Buider 오류)
@AllArgsConstructor // 모든 필드를 포함하는 생성자를 생성
@Builder // 빌더 패턴을 생성
public class Product extends BaseEntity{	// 여기서 extends 해도 jpa 할 때만 쓰고 db에 추가하면 j클래스에도 반영됨
	@Id
	private String id;
	
	@Enumerated(EnumType.STRING)	// string 아닌 기본값 ordinal은 숫자로 저장 -> 추가하면 겹치는 문제 발생
	private Category category;
	
	private String name;
	
	private Integer price;
	
	// 사이즈, 색상 -> 별도 테이블
}
