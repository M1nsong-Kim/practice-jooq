package com.practice.practice_jooq.base;

import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.springframework.util.CollectionUtils;

import io.micrometer.common.util.StringUtils;

// 출처 https://github.com/SightStudio/blog-code/blob/develop/jooq-advanced/src/main/java/com/sightstudio/jooq/config/jooq/BaseJooqRepository.java#L14

public interface BaseJooqRepository {
    default Condition inIfNotEmpty(TableField<? extends Record, Integer> columnVal, List<Integer> paramVal) {
        if(CollectionUtils.isEmpty(paramVal)) {
            return DSL.noCondition();	// jooq where절에서 이를 리턴하면 조건에서 제외된다
        }
        return columnVal.in(paramVal);
    }

    default Condition likeIfNotEmpty(TableField<? extends Record, String> column, String searchInput, TextSearchWildcard searchWildcard) {

        if(StringUtils.isBlank(searchInput)) {
            return DSL.noCondition();
        }

        switch (searchWildcard) {
            case FULL_TEXT:
                return column.like("%" + searchInput + "%");
            case PREFIX:
                return column.like("%" + searchInput);
            case SUFFIX:
                return column.like(searchInput + "%");
            case NONE:
                return column.eq(searchInput);
        }

        return DSL.noCondition();
    }

    default Condition likeIfNotEmpty(TableField<? extends Record, String> column, String searchInput) {
        return likeIfNotEmpty(column, searchInput, TextSearchWildcard.NONE);
    }
}
