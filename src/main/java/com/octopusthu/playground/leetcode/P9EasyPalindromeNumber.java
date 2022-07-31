package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
public class P9EasyPalindromeNumber {

  /**
   * @param x the number
   * @return if the number is a palindrome number
   */
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int quotient = x;
    int remainder;
    List<Integer> digits = new ArrayList<>();
    do {
      remainder = quotient % 10;
      quotient /= 10;
      digits.add(remainder);
    } while (quotient != 0);

    return isPalindrome(digits);
  }

  private boolean isPalindrome(List<Integer> digits) {
    int left = 0, right = digits.size() - 1;
    do {
      if (digits.get(left).intValue() != digits.get(right).intValue()) {
        return false;
      }
      left++;
      right--;
    } while (right > left);
    return true;
  }

  @Test
  void testIsPalindrome() {
    Assertions.assertTrue(isPalindrome(121));
    Assertions.assertTrue(isPalindrome(111));
    Assertions.assertTrue(isPalindrome(1));
    Assertions.assertTrue(isPalindrome(0));

    Assertions.assertFalse(isPalindrome(-121));
    Assertions.assertFalse(isPalindrome(10));
    Assertions.assertFalse(isPalindrome(123));
    Assertions.assertFalse(isPalindrome(21));
  }

}
