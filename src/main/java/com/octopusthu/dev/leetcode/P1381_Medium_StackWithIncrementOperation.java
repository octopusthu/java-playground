package com.octopusthu.dev.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 1381. Design a Stack With Increment Operation
 *
 * @author octopusthu@gmail.com
 * @date 2022/8/1
 */
public class P1381_Medium_StackWithIncrementOperation {

    class CustomStack {

        /**
         * Stack data
         */
        private final int[] data;

        /**
         * <code>data[0]</code> - <code>data[i]</code> each has an increment of <code>increment[i]</code>
         */
        private final int[] increment;

        /**
         * Index of the current top element
         */
        private int top = -1;

        public CustomStack(int maxSize) {
            this.data = new int[maxSize];
            this.increment = new int[maxSize];
        }

        public void push(int x) {
            if (top != data.length - 1) {
                data[++top] = x;
            }
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            int popped = data[top] + increment[top];
            if (top != 0) {
                this.increment[top - 1] += increment[top];
            }
            increment[top] = 0;
            top--;
            return popped;
        }

        public void increment(int k, int val) {
            if (top != -1) {
                increment[Math.min(k - 1, top)] += val;
            }
        }
    }

    class CustomStackTester {

        private CustomStack stack = null;

        Integer[] execute(String[] operations, int[][] data) {
            List<Integer> result = new ArrayList<>(operations.length);
            for (int i = 0; i < operations.length; i++) {
                result.add(executeOperation(operations[i], data[i]));
            }
            return result.toArray(new Integer[0]);
        }

        Integer executeOperation(String operation, int[] data) {
            switch (operation) {
                case "CustomStack":
                    stack = new CustomStack(data[0]);
                    return null;
                case "push":
                    stack.push(data[0]);
                    return null;
                case "pop":
                    return stack.pop();
                case "increment":
                    stack.increment(data[0], data[1]);
                    return null;
                default:
                    throw new RuntimeException("Unknown operation: " + operation);
            }
        }

    }

    @Test
    void testCustomStack() {
        CustomStackTester tester = new CustomStackTester();
        Assertions.assertArrayEquals(
            new Integer[]{null, null, null, 2, null, null, null, null, null, 103, 202, 201, -1},
            tester.execute(
                new String[]{"CustomStack", "push", "push", "pop", "push", "push", "push", "increment", "increment",
                    "pop", "pop", "pop", "pop"},
                new int[][]{{3}, {1}, {2}, {}, {2}, {3}, {4}, {5, 100}, {2, 100}, {}, {}, {}, {}}
            )
        );
        Assertions.assertArrayEquals(
            new Integer[]{null, -1, null, null, null, null, null, 229, null},
            tester.execute(
                new String[]{"CustomStack", "pop", "increment", "push", "increment", "increment", "increment", "pop",
                    "increment"},
                new int[][]{{30}, {}, {3, 40}, {30}, {4, 63}, {2, 79}, {5, 57}, {}, {5, 32}}
            )
        );
    }
}
