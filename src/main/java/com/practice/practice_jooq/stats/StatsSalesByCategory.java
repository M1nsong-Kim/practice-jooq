package com.practice.practice_jooq.stats;

import com.practice.practice_jooq.categories.Category;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class StatsSalesByCategory {	// view
	@Enumerated(EnumType.STRING)	// string 아닌 기본값 ordinal은 숫자로 저장 -> 추가하면 겹치는 문제 발생
	private Category category;
	
	private Integer count;
	
	private Integer rate;	// 전체 점유율
}
