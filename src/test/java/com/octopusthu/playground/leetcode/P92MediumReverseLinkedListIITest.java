package com.octopusthu.playground.leetcode;

import com.octopusthu.playground.leetcode.common.ListNodeHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class P92MediumReverseLinkedListIITest {
  final P92MediumReverseLinkedListII target = new P92MediumReverseLinkedListII();
  static int[][][] testData;

  @BeforeAll
  static void init() {
    testData = new int[][][]{
      {{1}, {1}, {1}, {1}}, // 1=m=n=length
      {{1, 2}, {1}, {1}, {1, 2}}, // 1=m=n<length
      {{1, 2}, {2}, {2}, {1, 2}}, // 1<m=n=length
      {{1, 2, 3}, {2}, {2}, {1, 2, 3}}, // 1<m=n<length
      {{1, 2, 3}, {1}, {3}, {3, 2, 1}}, // 1=m<n=length
      {{1, 2, 3, 4}, {1}, {3}, {3, 2, 1, 4}}, // 1=m<n<length
      {{1, 2, 3, 4}, {2}, {4}, {1, 4, 3, 2}}, // 1<m<n=length
      {{1, 2, 3, 4}, {2}, {3}, {1, 3, 2, 4}}, // 1<m<n<length
      {{1, 2, 3, 4, 5, 6, 7}, {3}, {5}, {1, 2, 5, 4, 3, 6, 7}}, // 1<m<n<length
    };
  }

  @Test
  void testReverseBetween() {
    for (int[][] data : testData) {
      testReverseListRecursively(data[0], data[1][0], data[2][0], data[3]);
    }
  }

  void testReverseListRecursively(int[] original, int start, int end, int[] expectedReversed) {
    int[] actualReversed = ListNodeHelper.listNodeToArray(target.reverseBetween(ListNodeHelper.arrayToListNode(original), start, end));
    Assertions.assertArrayEquals(expectedReversed, actualReversed);
  }

}
