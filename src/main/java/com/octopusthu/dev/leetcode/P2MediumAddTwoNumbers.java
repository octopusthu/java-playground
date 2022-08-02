package com.octopusthu.dev.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author octopusthu@gmail.com
 */
public class P2MediumAddTwoNumbers {

  /**
   * Add from low to high, mind the carrying conditions.
   *
   * @param l1 the first integer
   * @param l2 the second integer
   * @return the sum
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null, cur = null;
    boolean carry = false;
    int val;
    while (l1 != null || l2 != null) {
      val = 0;
      if (l1 != null) {
        val += l1.val;
      }
      if (l2 != null) {
        val += l2.val;
      }
      if (carry) {
        val += 1;
      }
      carry = false;
      if (val > 9) {
        carry = true;
        val -= 10;
      }
      if (head == null) {
        cur = head = new ListNode(val);
      } else {
        cur.next = new ListNode(val);
        cur = cur.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry) {
      cur.next = new ListNode(1);
    }
    return head;
  }

  @Test
  void testAddTwoNumbers() {
    Assertions.assertTrue(doTest(null, null, null));
    Assertions.assertTrue(doTest(null, new int[]{5, 6, 4}, new int[]{5, 6, 4}));
    Assertions.assertTrue(doTest(new int[]{5, 6, 4}, null, new int[]{5, 6, 4}));
    Assertions.assertTrue(doTest(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}));
    Assertions.assertTrue(doTest(new int[]{9, 9, 9}, new int[]{1}, new int[]{0, 0, 0, 1}));
  }

  boolean doTest(int[] arr1, int[] arr2, int[] arrExpected) {
    ListNode expected = arrayToListNode(arrExpected);
    ListNode l1 = arrayToListNode(arr1);
    ListNode l2 = arrayToListNode(arr2);
    return (l1 == null && l2 == null) ? expected == null : expected.equals(addTwoNumbers(l1, l2));
  }

  ListNode arrayToListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
      return null;
    }
    ListNode head = null, current = null, temp;
    for (int j : arr) {
      if (head == null) {
        head = new ListNode(j);
        current = head;
      } else {
        temp = new ListNode(j);
        current.next = temp;
        current = temp;
      }
    }
    return head;
  }

  private static class ListNode {
    int val;
    ListNode next;

//  ListNode() {
//  }

    ListNode(int val) {
      this.val = val;
    }

//  ListNode(int val, ListNode next) {
//    this.val = val;
//    this.next = next;
//  }

    @Override
    public int hashCode() {
      return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ListNode)) {
        return false;
      }

      ListNode toCompare = (ListNode) obj;
      return this.val == toCompare.val && Objects.equals(this.next, toCompare.next);
    }
  }

}
