package com.octopusthu.playground.leetcode;

import com.octopusthu.playground.leetcode.common.ListNode;

/**
 * @author octopusthu@gmail.com
 */
public class P206EasyReverseLinkedList {

  /**
   * @param head the list
   * @return the reversed list
   */
  public ListNode reverseList(ListNode head) {
    return reverseListRecursively(head, null);
//    return reverseListIteratively(head);
  }

  ListNode reverseListIteratively(ListNode head) {
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

  ListNode reverseListRecursively(ListNode head, ListNode previous) {
    if (head == null) {
      return null;
    }
    ListNode newHead = new ListNode(head.val, previous);
    if (head.next == null) {
      return newHead;
    }
    return reverseListRecursively(head.next, newHead);
  }

}
