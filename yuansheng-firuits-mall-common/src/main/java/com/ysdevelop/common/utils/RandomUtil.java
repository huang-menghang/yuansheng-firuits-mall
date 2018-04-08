package com.ysdevelop.common.utils;

import java.util.Random;

public class RandomUtil {
	private static String number = "0123456789";

	private static String letter = "qwertyuiopasdfghjklzxcvbnm1234567890";

	private static final Random random = new Random();

	public static String randomNumber(Integer numberLength) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < numberLength; i++) {
			int index = random.nextInt(number.length());
			buffer.append(number.charAt(index));
		}
		return buffer.toString();
	}
	
	public static String randomString(Integer numberLength) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < numberLength; i++) {
			int index = random.nextInt(number.length());
			buffer.append(letter.charAt(index));
		}
		return buffer.toString();
	}
}
