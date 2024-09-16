package com.practice.practice_jooq.member;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	@Id
	private String id;
	
	private String password;
	
	private String name;
	
	@Column(name = "id_number")
	private Integer idNumber;	// 주민번호 앞자리. 추후 나이 계산
}
