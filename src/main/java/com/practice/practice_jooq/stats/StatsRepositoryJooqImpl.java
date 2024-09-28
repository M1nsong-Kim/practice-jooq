package com.practice.practice_jooq.stats;

//import static com.practice.practice_jooq.generated.tables.StatsSalesByCategory.STATS_SALES_BY_CATEGORY;
// view 생성 후 J 클래스 정상 생성

import static com.practice.practice_jooq.generated.tables.Purchase.PURCHASE;

import java.util.List;

import org.jooq.DSLContext;

public class StatsRepositoryJooqImpl implements StatsRepositoryJooq{

	private final DSLContext dsl;

	public StatsRepositoryJooqImpl(DSLContext dsl) {
		this.dsl = dsl;
	}

	@Override
	public List<StatsSalesByCategory> selectStatsSalesByCategory() {
//		return dsl.select()
//				.from(null)
//				;
		return null;
	}
	
}
