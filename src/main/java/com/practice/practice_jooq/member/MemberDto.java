package com.practice.practice_jooq.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정(DTO에서만 사용)
@NoArgsConstructor // 기본 생성자를 생성(둘중 하나만 쓰면 @Buider 오류)
@AllArgsConstructor // 모든 필드를 포함하는 생성자를 생성
@Builder // 빌더 패턴을 생성
public class MemberDto {
	private String id;
	private String password;
	private String name;
	private Integer idNumber;
}
