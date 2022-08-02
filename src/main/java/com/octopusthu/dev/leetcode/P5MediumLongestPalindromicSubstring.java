package com.octopusthu.dev.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author octopusthu@gmail.com
 */
public class P5MediumLongestPalindromicSubstring {

  /**
   * Start searching from the center of the String, and expand leftward and rightward, until find the theoretically longest solution.
   *
   * @param s The string
   * @return The longest palindrome substring
   */
  public String longestPalindrome(String s) {
    if (s == null) {
      return null;
    }

    int len = s.length();
    if (len <= 1) {
      return s;
    }

    String solution;
    boolean even = len % 2 == 0;
    int median = len / 2;
    int maxLen = even ? median * 2 : median * 2 + 1;
    String currentSolution = search(s, even, median);
    solution = currentSolution;
    int medianLeft = median, medianRight = median;
    String currentSolutionLeft, currentSolutionRight;
    while (currentSolution.length() != maxLen) {
      medianLeft = even ? medianLeft - 1 : medianLeft;
      medianRight = even ? medianRight : medianRight + 1;
      maxLen--;
      even = !even;
      currentSolutionLeft = search(s, even, medianLeft);
      currentSolutionRight = search(s, even, medianRight);
      if (currentSolutionLeft.length() >= currentSolutionRight.length()) {
        currentSolution = currentSolutionLeft;
      } else {
        currentSolution = currentSolutionRight;
      }
      solution = currentSolution.length() > solution.length() ? currentSolution : solution;
    }

    return solution;
  }

  private String search(String s, boolean even, int median) {
    StringBuilder builder = new StringBuilder();
    if (!even) {
      builder.append(s.charAt(median));
    }
    int left = median - 1;
    int right = even ? median : median + 1;
    char ch;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      ch = s.charAt(left);
      builder.append(ch);
      builder.insert(0, ch);
      left--;
      right++;
    }
    return builder.toString();
  }

  @Test
  void testLongestPalindrome() {
    Assertions.assertEquals("", longestPalindrome(""));
    Assertions.assertEquals("a", longestPalindrome("a"));
    Assertions.assertEquals("bb", longestPalindrome("cbbd"));
    Assertions.assertEquals("abccba", longestPalindrome("abccba"));
    Assertions.assertEquals("abcdcba", longestPalindrome("abcdcba"));
    Assertions.assertEquals("abababa", longestPalindrome("abababa"));
    Assertions.assertEquals("aaaaa", longestPalindrome("aaaaa"));

    String result = longestPalindrome("babad");
    Assertions.assertTrue("bab".equals(result) || "aba".equals(result));

    Assertions.assertEquals("adada", longestPalindrome("babadada"));
  }

}
