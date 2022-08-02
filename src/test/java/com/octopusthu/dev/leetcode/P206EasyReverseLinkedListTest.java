package com.octopusthu.dev.leetcode;

import com.octopusthu.dev.leetcode.common.ListNodeHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class P206EasyReverseLinkedListTest {
  final P206EasyReverseLinkedList target = new P206EasyReverseLinkedList();
  static int[][][] testData;

  @BeforeAll
  static void init() {
    testData = new int[][][]{
      {{}, {}},
      {{0}, {0}},
      {{1}, {1}},
      {{1, 2, 3}, {3, 2, 1}},
      {{1, 1, 1, 1}, {1, 1, 1, 1}}
    };
  }

  @Test
  void testReverseList() {
    for (int[][] data : testData) {
      testReverseListIteratively(data[0], data[1]);
      testReverseListRecursively(data[0], data[1]);
    }
  }

  void testReverseListIteratively(int[] original, int[] expectedReversed) {
    Assertions.assertArrayEquals(expectedReversed, ListNodeHelper.listNodeToArray(target.reverseListIteratively(ListNodeHelper.arrayToListNode(original))));
  }

  void testReverseListRecursively(int[] original, int[] expectedReversed) {
    Assertions.assertArrayEquals(expectedReversed, ListNodeHelper.listNodeToArray(target.reverseListRecursively(ListNodeHelper.arrayToListNode(original), null)));
  }

}
