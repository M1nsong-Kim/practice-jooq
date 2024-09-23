package com.practice.practice_jooq.base;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.querydsl.entity.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass	// 실제 entity 아니지만 Entity가 Entity 클래스끼리만 상속받을 수 있기 때문에 이 어노테이션을 추가함 -> 조회, 검색 불가 / 추상 클래스 권장
@EntityListeners(AuditingEntityListener.class)	// 해당 어노테이션 넣는 게 귀찮으면 META_INF/orm.xml에 소스 추가하는 방법도 있다
public abstract class BaseEntity extends BaseTimeEntity{
	@CreatedBy 	// by : Application에 작성 필수
	@Column(updatable = false)
	private String register;	
	
	@LastModifiedBy 
	private String updater;
}
