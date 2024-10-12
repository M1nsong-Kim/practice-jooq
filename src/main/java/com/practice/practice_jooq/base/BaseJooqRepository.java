package com.practice.practice_jooq.base;

import static org.jooq.impl.DSL.*;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.springframework.util.CollectionUtils;

import com.practice.practice_jooq.categories.TextSearchWildcard;
import com.practice.practice_jooq.categories.TimePeriod;

import io.micrometer.common.util.StringUtils;

// 출처 https://github.com/SightStudio/blog-code/blob/develop/jooq-advanced/src/main/java/com/sightstudio/jooq/config/jooq/BaseJooqRepository.java#L14

public interface BaseJooqRepository {
	
    default Condition inIfNotEmpty(TableField<? extends Record, Integer> columnVal, List<Integer> paramVal) {
        if(CollectionUtils.isEmpty(paramVal)) {
            return noCondition();	// jooq where절에서 이를 리턴하면 조건에서 제외된다
        }
        return columnVal.in(paramVal);
    }

															// String -> T로 바꿔서 enum도 쓸 수 있도록
    default <T> Condition likeIfNotEmpty(TableField<? extends Record, T> column, String searchInput, TextSearchWildcard searchWildcard) {

        if(StringUtils.isBlank(searchInput)) {
            return noCondition();
        }
        
        switch (searchWildcard) {
            case FULL_TEXT:
                return column.like("%" + searchInput + "%");
            case PREFIX:
                return column.like("%" + searchInput);
            case SUFFIX:
                return column.like(searchInput + "%");
            case NONE:
                return column.eq((T) searchInput);
        }

        return noCondition();
    }

    default Condition likeIfNotEmpty(TableField<? extends Record, String> column, String searchInput) {
        return likeIfNotEmpty(column, searchInput, TextSearchWildcard.NONE);
    }
    
//    default Condition eqIfNotEmpty(TableField<? extends Record, String> column, String searchInput) {
//		return DSL.noCondition();
//	}
    
    // 기간
    default <T> Condition PeriodIfNotEmpty(TableField<? extends Record, T> column, TimePeriod standard) {
    	if(standard == null) {
            return noCondition();
        }

    	LocalDateTime today = LocalDateTime.now();
    	
    	switch(standard) {
    		case YEAR:
    			return year(column).eq(today.getYear());
    		case MONTH:
    			return month(column).eq(today.getMonthValue());
    		case DAY:
    			return day(column).eq(today.getDayOfMonth());
    		case HOUR:
    			return hour(column).eq(today.getHour());
    	}
    	
    	return noCondition();
    }
}
