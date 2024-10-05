package com.practice.practice_jooq.stats;

import java.util.List;

public interface StatsRepositoryJooq {
//	List<StatsSalesByCategory> selectStatsSalesByCategory();
	List<StatsDto> selectStatsSalesByCategory();
	List<StatsDto> selectStatsSalesByGender();
	List<RankDto> selectRankSalesByAll(String standard, String kind);	// 월간 / 바지
}
