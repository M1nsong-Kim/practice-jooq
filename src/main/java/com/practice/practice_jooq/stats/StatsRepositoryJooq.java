package com.practice.practice_jooq.stats;

import java.util.List;

import com.practice.practice_jooq.categories.TimePeriod;

public interface StatsRepositoryJooq {
//	List<StatsSalesByCategory> selectStatsSalesByCategory();
	List<StatsDto> selectStatsSalesByCategory();
	List<StatsDto> selectStatsSalesByGender();
	List<RankDto> selectRankSalesByAll(TimePeriod standard, String kind);	// 월간 / 바지
}
