package com.octopusthu.dev.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RemoveArrayElementTest {
    final RemoveArrayElement target = new RemoveArrayElement();
    static Object[][] testData;

    @BeforeAll
    static void init() {
        testData = new Object[][]{
            {new int[]{1, 2, 3}, 1, List.of(2, 3)},
            {new int[]{3, 2, 1, 3}, 3, List.of(2, 1)},
            {new int[]{2, 2, 1, 1}, 2, List.of(1, 1)},
            {new int[]{1, 1, 2, 2}, 2, List.of(1, 1)},
            {new int[]{}, 1, List.of()},
            {new int[]{1}, 1, List.of()},
            {new int[]{1}, 2, List.of(1)},
            {new int[]{1, 2}, 1, List.of(2)},
            {new int[]{2, 1}, 1, List.of(2)},
            {new int[]{1, 1, 1}, 1, List.of()},
        };
    }

    @Test
    void testRemoveArrayElement() {
        for (Object[] data : testData) {
            int[] arr = (int[]) data[0];
            arr = Arrays.copyOf(arr, arr.length);
            int val = (int) data[1];
            @SuppressWarnings("unchecked")
            List<Integer> expected = (List<Integer>) data[2];
            int remained = target.removeByPointersAtBothEnds(arr, val);
            assertResult(arr, remained, expected);
        }
    }

    void assertResult(int[] arr, int remained, List<Integer> expected) {
        expected = new ArrayList<>(expected);
        Assertions.assertEquals(expected.size(), remained);
        for (int i = 0; i < remained; i++) {
            if (!expected.remove((Object) arr[i])) {
                Assertions.fail(String.format("unexpected remaining element: %d", arr[i]));
            }
        }
        if (!expected.isEmpty()) {
            Assertions.fail("expected elements not present in remained array: " + Arrays.toString(
                expected.toArray()));
        }
    }

}
