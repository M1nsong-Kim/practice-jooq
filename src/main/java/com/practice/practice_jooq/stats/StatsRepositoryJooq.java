package com.practice.practice_jooq.stats;

import java.util.List;

public interface StatsRepositoryJooq {
	List<StatsSalesByCategory> selectStatsSalesByCategory();
}
