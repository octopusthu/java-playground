package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Use recursion (divide-and-conquer) to improve efficiency.
 */
public class P1562MediumFindLatestGroupOfSizeM {

  public int findLatestStep(int[] arr, int m) {
    int n = arr.length;
    return this.findLatestStep(arr, m, n, 0, n);
  }

  public int findLatestStep(int[] arr, int m, int step, int start, int end) {
    int n = arr.length;

    /* no solution */
    if (start > n - 1 || end - start < m) {
      return -1;
    }

    /* judge */
    if (end - start == m) {
      return step;
    }

    /* cannot divide further */
    if (step == 1) {
      return -1;
    }

    /* divide */
    int index = arr[step - 1] - 1;
    if (start <= index && index < end) {
      return Math.max(
        this.findLatestStep(arr, m, step - 1, start, index),
        this.findLatestStep(arr, m, step - 1, index + 1, end));
    } else {
      return this.findLatestStep(arr, m, step - 1, start, end);
    }
  }

  @Test
  void testFindLatestStep() {
    Assertions.assertEquals(1, findLatestStep(new int[]{1}, 1));
    Assertions.assertEquals(2, findLatestStep(new int[]{2, 1}, 2));
    Assertions.assertEquals(4, findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
    Assertions.assertEquals(-1, findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
    Assertions.assertEquals(1, findLatestStep(new int[]{4, 3, 2, 1}, 1));
    Assertions.assertEquals(8, findLatestStep(new int[]{1, 9, 12, 6, 4, 5, 3, 13, 2, 11, 10, 7, 8}, 4));
  }

}
