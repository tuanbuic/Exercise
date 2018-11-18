package utilities;

import java.util.Random;

public class StringUtil {
	private static Random generate = new Random();

	public static String randomString(int length) {
		String charsList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		int charLen = charsList.length();
		StringBuilder rString = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char rChar = charsList.charAt(generate.nextInt(charLen));
			rString.append(rChar);
		}
		return rString.toString();
	}

	public static String randomRangeNumber(int min, int max) {
		int rNumber = generate.nextInt(max - min + 1) + min;
		return String.valueOf(rNumber);
	}
}
