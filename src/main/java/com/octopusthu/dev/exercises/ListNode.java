package com.octopusthu.dev.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode<T> {
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
        var thisCurrent = this;
        var thatCurrent = that;
        while (thisCurrent != null && thatCurrent != null) {
            if (!Objects.equals(thisCurrent.getVal(), thatCurrent.getVal())) {
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
        }
        return thisCurrent == null && thatCurrent == null;
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
