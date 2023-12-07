package com.octopusthu.dev.exercises;

import com.octopusthu.dev.exercises.DeduplicateOrderedList.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DeduplicateOrderedListTest {
    final DeduplicateOrderedList target = new DeduplicateOrderedList();
    static Integer[][][] testData;

    @BeforeAll
    static void init() {
        testData = new Integer[][][]{
            new Integer[][]{new Integer[]{1, 2, 3, 3, 4, 4, 5}, new Integer[]{1, 2, 3, 4, 5}},
            new Integer[][]{new Integer[]{1, 2, 3, 3, 3, 4}, new Integer[]{1, 2, 3, 4}},
            new Integer[][]{new Integer[]{1, 1, 2, 3, 4, 5}, new Integer[]{1, 2, 3, 4, 5}},
            new Integer[][]{new Integer[]{1, 2, 3, 4, 5, 5}, new Integer[]{1, 2, 3, 4, 5}},
            new Integer[][]{new Integer[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, new Integer[]{1, 2, 3, 4, 5}},
            new Integer[][]{new Integer[]{1}, new Integer[]{1}},
            new Integer[][]{new Integer[]{1, 1, 1}, new Integer[]{1}},
        };
    }

    @Test
    void testRemoveArrayElement() {
        for (Integer[][] data : testData) {
            ListNode<Integer> list = ListNode.makeList(data[0]);
            target.deduplicateOrderedList(list);
            Assertions.assertEquals(ListNode.makeList(data[1]), list);
        }
    }
}
