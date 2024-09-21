package com.practice.practice_jooq.member;

import static com.practice.practice_jooq.generated.tables.Member.MEMBER;

import java.util.List;

import org.jooq.DSLContext;

public class MemberRepository {
	private final DSLContext dsl;

	public MemberRepository(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public List<MemberDto> getMemberList(){
		return dsl.select()
				.from(MEMBER)
				.fetchInto(MemberDto.class);
	}
}
