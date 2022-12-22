package com.qa.API.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtils {

	public static String empName() {

		String name = RandomStringUtils.randomAlphabetic(1);
		return ("John" + name);
	}
	
	public static String empSal() {
		
		return RandomStringUtils.randomNumeric(5);
		
	}
	
	public static String empAge() {
		
		return RandomStringUtils.randomNumeric(2);
	}

}
