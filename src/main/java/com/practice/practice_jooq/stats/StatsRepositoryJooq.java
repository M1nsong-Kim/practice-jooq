package com.practice.practice_jooq.stats;

import org.jooq.Record;
import org.jooq.Result;

public interface StatsRepositoryJooq {
//	List<StatsSalesByCategory> selectStatsSalesByCategory();
	Result<Record> selectStatsSalesByCategory();
}
