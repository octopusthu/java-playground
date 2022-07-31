package com.octopusthu.playground.leetcode;

import com.octopusthu.playground.leetcode.common.ListNode;

/**
 * @author octopusthu@gmail.com
 */
public class P92MediumReverseLinkedListII {

  /**
   * @param head the list
   * @param m    start position (counting from 1)
   * @param n    end position (counting from 1)
   * @return the reversed list
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    return m == n ? head :
      m == 1 ?
        reverseBetweenRecursively(null, null, head, head, null, m, n) :
        reverseBetweenRecursively(head, null, null, head, null, m, n);
  }

  private ListNode reverseBetweenRecursively(ListNode head, ListNode beforeCut, ListNode afterCut, ListNode current, ListNode previous, int m, int n) {
    if (m > 1) {
      return reverseBetweenRecursively(head, beforeCut, afterCut, current.next, current, m - 1, n - 1);
    } else if (m == 1) {
      return reverseBetweenRecursively(head, previous, current, current.next, current, m - 1, n - 1);
    } else if (n > 1) {
      ListNode next = current.next;
      current.next = previous;
      return reverseBetweenRecursively(head, beforeCut, afterCut, next, current, m - 1, n - 1);
    } else {
      assert n == 1;
      ListNode next = current.next;
      current.next = previous;
      if (beforeCut != null) {
        beforeCut.next = current;
      }
      afterCut.next = next;
      if (head == null) {
        head = current;
      }
      return head;
    }
  }

}
