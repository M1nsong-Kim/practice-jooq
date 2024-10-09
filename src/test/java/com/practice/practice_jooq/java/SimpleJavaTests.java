package com.practice.practice_jooq.java;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class SimpleJavaTests {
	
	@Test
	public void localdatetimeTest() {
		LocalDateTime today = LocalDateTime.now();
    	
    	System.out.println("::::::::::::::::::" + today.getYear()+""+today.getMonthValue()+""+today.getDayOfMonth()+""+today.getHour());
	}
}
