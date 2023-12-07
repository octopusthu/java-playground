package com.octopusthu.dev.exercises;

import java.util.Objects;

/**
 * 1->2->3->3->4->4->5 =><br>
 * 1->2->3->4->5<br>
 */
public class DeduplicateOrderedList {
    void deduplicateOrderedList(ListNode<Integer> list) {
        if (list.getNext() == null) {
            return;
        }
        ListNode<Integer> p1 = list, p2 = list.getNext();
        while (p2 != null) {
            if (!Objects.equals(p1.getVal(), p2.getVal())) {
                p1 = p1.getNext();
                p2 = p2.getNext();
                continue;
            }
            while (p2.getNext() != null && Objects.equals(p2.getVal(), p2.getNext().getVal())) {
                p2 = p2.getNext();
            }
            p1.setNext(p2.getNext());
            p2 = p2.getNext();
        }
    }
}
