package com.practice.practice_jooq.stats;

import static com.practice.practice_jooq.generated.tables.Member.MEMBER;
import static com.practice.practice_jooq.generated.tables.Product.PRODUCT;

//import static com.practice.practice_jooq.generated.tables.StatsSalesByCategory.STATS_SALES_BY_CATEGORY;
// view 생성 후 J 클래스 정상 생성

import static com.practice.practice_jooq.generated.tables.Purchase.PURCHASE;
// rollup 등
import static org.jooq.impl.DSL.date;
import static org.jooq.impl.DSL.rollup;
import static org.jooq.impl.DSL.sum;

import java.util.List;

import org.jooq.DSLContext;

import com.practice.practice_jooq.generated.enums.PurchaseStatus;

public class StatsRepositoryJooqImpl implements StatsRepositoryJooq{

	private final DSLContext dsl;

	public StatsRepositoryJooqImpl(DSLContext dsl) {
		this.dsl = dsl;
	}

	@Override
	public List<StatsDto> selectStatsSalesByCategory() {
			return dsl.select(
						date(PURCHASE.REGISTER_DTM.toString())
						, PRODUCT.CATEGORY
						, sum(PURCHASE.COUNT)
					)
					.from(PURCHASE)
					.join(PRODUCT)
						.on(PURCHASE.PRODUCT_ID.eq(PRODUCT.ID))
					.where(PURCHASE.STATUS.eq(PurchaseStatus.Completed))
					.groupBy(rollup(date(PURCHASE.REGISTER_DTM.toString()), PRODUCT.CATEGORY))
					.fetchInto(StatsDto.class);
	}

	@Override
	public List<StatsDto> selectStatsSalesByGender() {
		return dsl.select(
				date(PURCHASE.REGISTER_DTM.toString())
				, MEMBER.GENDER
				, sum(PURCHASE.COUNT)
			)
			.from(PURCHASE)
			.join(MEMBER)
				.on(PURCHASE.MEMBER_ID.eq(MEMBER.ID))
			.where(PURCHASE.STATUS.eq(PurchaseStatus.Completed))
			.groupBy(rollup(date(PURCHASE.REGISTER_DTM.toString()), MEMBER.GENDER))
			.fetchInto(StatsDto.class);
	}
	
}
