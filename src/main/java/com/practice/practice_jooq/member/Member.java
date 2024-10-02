package com.practice.practice_jooq.member;

import com.practice.practice_jooq.base.BaseTimeEntity;
import com.practice.practice_jooq.categories.Grade;
import com.practice.practice_jooq.categories.Role;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
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
@Table(name = "member")
@Getter
//Builder 사용 시 불필요 @RequiredArgsConstructor
@ToString
@NoArgsConstructor // 기본 생성자를 생성(둘중 하나만 쓰면 @Buider 오류)
@AllArgsConstructor // 모든 필드를 포함하는 생성자를 생성
@Builder // 빌더 패턴을 생성	
public class Member extends BaseTimeEntity {
	@Id
	private String id;
	
	private String password;
	
	private String name;
	
	private Integer gender;
	
	@Column(name = "id_number")
	private String idNumber;	// 주민번호 앞자리. 추후 나이 계산
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING) 
	@Nullable	// user만 grade 있음
	private Grade grade;
}
