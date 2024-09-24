package com.practice.practice_jooq.member;

import static com.practice.practice_jooq.generated.tables.Member.MEMBER;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRepositoryJooqImpl implements MemberRepositoryJooq{
	
//	@Autowired 
	private final DSLContext dsl;

	public MemberRepositoryJooqImpl(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public List<MemberDto> getMemberList(){
		return dsl.select()
				.from(MEMBER)
				.fetchInto(MemberDto.class);
	}
	
	// insert는 jpa 기본
}
