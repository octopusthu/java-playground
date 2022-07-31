package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P1551MediumMinimumOperationsToMakeArrayEqual {

  public int minOperations(int n) {
    boolean odd = n % 2 != 0;
    int medianIndex = odd ? (n - 1) / 2 : (n / 2) - 1;
    int ret = 0;
    if (odd) {
      for (int i = medianIndex - 1; i >= 0; i--) {
        ret += (medianIndex - i) * 2;
      }
    } else {
      for (int i = medianIndex; i >= 0; i--) {
        ret += (medianIndex - i) * 2 + 1;
      }
    }
    return ret;
  }

  @Test
  void testMinOperations() {
    Assertions.assertEquals(0, minOperations(1));
    Assertions.assertEquals(2, minOperations(3));
    Assertions.assertEquals(9, minOperations(6));
  }

}
