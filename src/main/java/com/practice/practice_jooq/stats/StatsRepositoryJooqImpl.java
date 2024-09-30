package com.practice.practice_jooq.stats;

import static com.practice.practice_jooq.generated.tables.Product.PRODUCT;

//import static com.practice.practice_jooq.generated.tables.StatsSalesByCategory.STATS_SALES_BY_CATEGORY;
// view 생성 후 J 클래스 정상 생성

import static com.practice.practice_jooq.generated.tables.Purchase.PURCHASE;

import static org.jooq.impl.DSL.*;			// rollup 등

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Result;

import com.practice.practice_jooq.generated.enums.ProductCategory;
import com.practice.practice_jooq.generated.enums.PurchaseStatus;

public class StatsRepositoryJooqImpl implements StatsRepositoryJooq{

	private final DSLContext dsl;

	public StatsRepositoryJooqImpl(DSLContext dsl) {
		this.dsl = dsl;
	}

	@Override
	public Result<Record> selectStatsSalesByCategory() {
			Result<Record> result = dsl.select(
						date(PURCHASE.REGISTER_DTM.toString())
						, PRODUCT.CATEGORY
						, sum(PURCHASE.COUNT)
					)
					.from(PURCHASE)
					.join(PRODUCT)
					.on(PURCHASE.PRODUCT_ID.eq(PRODUCT.ID))
					.where(PURCHASE.STATUS.eq(PurchaseStatus.Completed))
					.groupBy(rollup(PURCHASE.REGISTER_DTM, PRODUCT.CATEGORY))
					.fetch();
			return result;
	}
	
}
