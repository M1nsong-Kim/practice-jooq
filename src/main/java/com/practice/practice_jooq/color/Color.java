package com.practice.practice_jooq.color;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "color")
@Getter
//Builder 사용 시 불필요 @RequiredArgsConstructor
@ToString
@NoArgsConstructor // 기본 생성자를 생성(둘중 하나만 쓰면 @Buider 오류)
@AllArgsConstructor // 모든 필드를 포함하는 생성자를 생성
@Builder // 빌더 패턴을 생성
public class Color {
	@Id @GeneratedValue
	private Integer id;
	
	@Column(name="product_id")
	private String ProductId;
	
	@Column(name="color_name")
	private String colorName;
}
