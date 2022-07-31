package com.octopusthu.playground.leetcode.common;

import java.util.Objects;

public class ListNodeHelper {
  public static int[] listNodeToArray(ListNode listNode) {
    int length = count(listNode);
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = listNode.val;
      listNode = listNode.next;
    }
    return arr;
  }

  public static ListNode arrayToListNode(int[] arr) {
    Objects.requireNonNull(arr);
    if (arr.length == 0) {
      return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode current = head, next;
    for (int i = 1; i < arr.length; i++) {
      next = new ListNode(arr[i]);
      current.next = next;
      current = next;
    }
    return head;
  }

  public static int count(ListNode listNode) {
    int length = 0;
    while (listNode != null) {
      length++;
      listNode = listNode.next;
    }
    return length;
  }

}
