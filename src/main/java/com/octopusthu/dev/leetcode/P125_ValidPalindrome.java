package com.octopusthu.dev.leetcode;

public class P125_ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}

		int len = s.length();
		if (len <= 1) {
			return true;
		}

		s = s.toLowerCase();
		int i = 0, j = len - 1;
		while (i < len && j >= 0 && i <= j) {
			while (!Character.isLetterOrDigit(s.charAt(i))) {
				if (i == len - 1) {
					return true;
				}
				i++;
			}
			while (!Character.isLetterOrDigit(s.charAt(j))) {
				if (j == 0) {
					return true;
				}
				j--;
			}
			if (i >= j) {
				return true;
			}
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
	}

}
