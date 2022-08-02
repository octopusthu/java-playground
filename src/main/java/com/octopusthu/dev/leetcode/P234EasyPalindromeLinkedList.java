package com.octopusthu.dev.leetcode;

import com.octopusthu.dev.leetcode.common.ListNode;

/**
 * @author octopusthu@gmail.com
 */
public class P234EasyPalindromeLinkedList {

  /**
   * 1. Find the midpoint
   * 2. Reverse the latter half
   * 3. Compare the two parts
   *
   * @param head the list
   * @return if the list is a palindrome
   */
  public boolean isPalindrome(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
      length++;
      current = current.next;
    }

    if (length <= 1) {
      return true;
    }

    int midpoint = length / 2;
    int pointer = 0;
    ListNode midpointNode = head;
    while (pointer < midpoint) {
      midpointNode = midpointNode.next;
      pointer++;
    }

    ListNode reversedLatterHalf = reverse(midpointNode);

    ListNode rightward = head, leftward = reversedLatterHalf;
    while (rightward != null && leftward != null) {
      if (rightward.val != leftward.val) {
        return false;
      }
      rightward = rightward.next;
      leftward = leftward.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode current = head;
    ListNode next = current.next;
    ListNode reversedNext = null;
    ListNode reversedCurrent = new ListNode(current.val, reversedNext);
    while (next != null) {
      reversedNext = reversedCurrent;
      reversedCurrent = new ListNode(next.val, reversedNext);
      current = next;
      next = current.next;
    }
    return reversedCurrent;
  }
}
