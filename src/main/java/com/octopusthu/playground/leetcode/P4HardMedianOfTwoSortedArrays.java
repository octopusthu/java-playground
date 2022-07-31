package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P4HardMedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    boolean isMedianSingle = (m + n) % 2 != 0;
    int medianIndex = isMedianSingle ? ((m + n - 1) / 2) : (((m + n) / 2) - 1);
    int[] merged = new int[isMedianSingle ? medianIndex + 2 : medianIndex + 3];
    int pointer = -1, pointer1 = 0, pointer2 = 0;

    while ((isMedianSingle && pointer < medianIndex) || (!isMedianSingle && pointer < medianIndex + 1)) {
      if (m == 0 || pointer1 >= m) {
        merged[++pointer] = nums2[pointer2];
        pointer2++;
      } else if (n == 0 || pointer2 >= n) {
        merged[++pointer] = nums1[pointer1];
        pointer1++;
      } else if (nums1[pointer1] < nums2[pointer2]) {
        merged[++pointer] = nums1[pointer1];
        pointer1++;
      } else if (nums1[pointer1] > nums2[pointer2]) {
        merged[++pointer] = nums2[pointer2];
        pointer2++;
      } else {
        merged[++pointer] = nums1[pointer1];
        merged[++pointer] = nums2[pointer2];
        pointer1++;
        pointer2++;
      }
    }

    return isMedianSingle ?
      (double) merged[medianIndex]
      :
      ((double) (merged[medianIndex] + merged[medianIndex + 1])) / 2;
  }

  @Test
  void testFindMedianSortedArrays() {
    Assertions.assertEquals(2.0d, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    Assertions.assertEquals(0.0d, findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
    Assertions.assertEquals(1.0d, findMedianSortedArrays(new int[]{}, new int[]{1}));
    Assertions.assertEquals(2.0d, findMedianSortedArrays(new int[]{2}, new int[]{}));
    Assertions.assertEquals(3.5d, findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    Assertions.assertEquals(4.0d, findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6, 8}));
    Assertions.assertEquals(2.5d, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }

}
