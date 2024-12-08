package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		char[] s1char = s1.toCharArray();
		char[] s2char = s2.toCharArray();

		if (s1char.length > s2char.length) {
			return s1;
		} else if (s2char.length > s1char.length) {
			return s2;
		}

		return "equal";
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.indexOf("underscores") != -1) {
			return s.replace(" ", "_");
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {

		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();

		String s1p = s1.substring(s1.indexOf(" "));
		String s2p = s2.substring(s2.indexOf(" "));
		String s3p = s3.substring(s3.indexOf(" "));

		String result = s1p;

		if (s2p.compareTo(result) < 0) {
			result = s2p;
		}

		if (s3p.compareTo(result) < 0) {
			result = s3p;
		}

		if (result.equals(s1p)) {
			return s1;
		} else if (result.equals(s2p)) {
			return s2;
		} else {
			return s3;
		}

	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;

		for (int x = 0; x < s.toCharArray().length; x++) {
			if (Character.isDigit(s.charAt(x))) {
				sum += Integer.parseInt(s.charAt(x) + "");

			}
		}

		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int result = 0;
		while (s.indexOf(substring) != -1) {
			result++;
			s = s.substring(0, s.indexOf(substring)) + s.substring(s.indexOf(substring) + 1);
		}

		return result;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] words = s.split(" ");
		int result = 0;
		for (String x : words) {
			if (x.length() >= substring.length() && x.substring(x.length() - substring.length()).equals(substring)) {
				
				result++;
			}
		}
		return result;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int result = 0 - s.indexOf(substring);
		
		System.out.println("first index   "  + s.indexOf(substring));
		int instances = substringCount(s, substring);

		for (int x = 0; x < instances-1; x++) {
			s = s.substring(0, s.indexOf(substring)) + s.substring(s.indexOf(substring) + 1);
		}
		
		System.out.println("second index   "   + s.indexOf(substring));
		result += s.indexOf(substring);

		return result;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
