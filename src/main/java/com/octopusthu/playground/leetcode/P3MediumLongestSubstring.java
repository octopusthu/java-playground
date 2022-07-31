package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class P3MediumLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }

    int length = 0;
    int start = 0;
    int current = 0;

    Map<Character, Integer> map = new HashMap<>(s.length());
    while (start < s.length()) {
      int[] ret = lengthOfLongestSubstring(s, map, start, current);

      if (ret == null) {
        length = compareSolutions(length, s.substring(start).length());
        break;
      }

      length = compareSolutions(length, s.substring(start, ret[1]).length());

      if (s.substring(ret[0] + 1).length() <= length) {
        break;
      }

      for (int i = start; i < ret[0] + 1; i++) {
        map.remove(s.charAt(i));
      }
      start = ret[0] + 1;
      current = ret[1];

    }

    return length;
  }

  /**
   * Sub procedure.
   *
   * @return former and latter index of the repeating character; null if no repeating character is found.
   */
  private int[] lengthOfLongestSubstring(String s, Map<Character, Integer> map, int start, int current) {
    for (int i = current; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!map.containsKey(ch)) {
        map.put(ch, i);
      } else {
        return new int[]{map.get(ch), i};
      }
    }
    return null;
  }

  private int compareSolutions(int a, int b) {
    return a >= b ? a : b;
  }

  public static void main(String[] args) {
    P3MediumLongestSubstring p3_Medium_LongestSubstring = new P3MediumLongestSubstring();
    Assertions.assertEquals(0, p3_Medium_LongestSubstring.lengthOfLongestSubstring(null));
    Assertions.assertEquals(0, p3_Medium_LongestSubstring.lengthOfLongestSubstring(""));
    Assertions.assertEquals(1, p3_Medium_LongestSubstring.lengthOfLongestSubstring("a"));
    Assertions.assertEquals(1, p3_Medium_LongestSubstring.lengthOfLongestSubstring("aa"));
    Assertions.assertEquals(3, p3_Medium_LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    Assertions.assertEquals(1, p3_Medium_LongestSubstring.lengthOfLongestSubstring("bbbbb"));
    Assertions.assertEquals(3, p3_Medium_LongestSubstring.lengthOfLongestSubstring("pwwkew"));
    Assertions.assertEquals(10, p3_Medium_LongestSubstring.lengthOfLongestSubstring("abcdefbghijk"));
  }

}
