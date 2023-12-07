package com.octopusthu.dev.exercises;

import java.util.ArrayList;
import java.util.List;
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

    static class ListNode<T> {
        private final T val;
        private ListNode<T> next;

        ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        T getVal() {
            return val;
        }

        void setNext(ListNode<T> next) {
            this.next = next;
        }

        ListNode<T> getNext() {
            return next;
        }

        List<T> toList() {
            var list = new ArrayList<T>();
            var current = this;
            while (current != null) {
                list.add(current.getVal());
                current = current.getNext();
            }
            return list;
        }

        @Override
        public String toString() {
            return toList().toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListNode<?> that)) {
                return false;
            }
            if (!Objects.equals(this.getVal(), that.getVal())) {
                return false;
            }
            if (this.getNext() == null) {
                return that.getNext() == null;
            }
            return this.getNext().equals(that.getNext());
        }

        static <T> ListNode<T> makeList(T[] nodes) {
            ListNode<T> current = null, next = null;
            for (int i = nodes.length - 1; i >= 0; i--) {
                current = new ListNode<>(nodes[i], next);
                next = current;
            }
            return current;
        }
    }
}
