package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author octopusthu@gmail.com
 */
public class P1EasyTwoSum {

  /**
   * @param nums   the array of numbers
   * @param target the expected sum
   * @return the array of the two indices
   */
  public int[] twoSum(int[] nums, int target) {
    int i1, i2;
    for (i1 = 0; i1 < nums.length - 1; i1++) {
      for (i2 = i1 + 1; i2 < nums.length; i2++) {
        if (nums[i1] + nums[i2] == target) {
          return new int[]{i1, i2};
        }
      }
    }
    return null;
  }

  @Test
  void testTwoSum() {
    Assertions.assertTrue(doTest(twoSum(new int[]{2, 7, 11, 15}, 9), 0, 1));
    Assertions.assertTrue(doTest(twoSum(new int[]{3, 2, 4}, 6), 1, 2));
    Assertions.assertTrue(doTest(twoSum(new int[]{3, 3}, 6), 0, 1));
  }

  boolean doTest(int[] actual, Integer... expected) {
    return actual.length == 2 &&
      (expected[0] == actual[0] && expected[1] == actual[1] || expected[0] == actual[1] && expected[1] == actual[0]);
  }

}
