package com.octopusthu.dev.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * LeetCode 2349. Design a Number Container System
 *
 * @author octopusthu@gmail.com
 * @date 2022/8/4
 */
public class P2349_Medium_NumberContainers {

    static class NumberContainersImpl implements NumberContainers {
        private final Map<Integer, Integer> indexNumberMap;
        private final Map<Integer, List<Integer>> numberIndicesMap;

        NumberContainersImpl() {
            this.indexNumberMap = new HashMap<>();
            this.numberIndicesMap = new HashMap<>();
        }

        public void change(int index, int number) {
            Integer oldNumber = indexNumberMap.get(index);
            if (oldNumber != null && oldNumber == number) {
                return;
            }
            indexNumberMap.put(index, number);
            if (oldNumber != null) {
                numberIndicesMap.get(oldNumber).remove(index);
            }

            List<Integer> indices = numberIndicesMap.computeIfAbsent(number, k -> new ArrayList<>());
            indices.add(index);
            Collections.sort(indices);
        }

        public int find(int number) {
            List<Integer> indices = numberIndicesMap.get(number);
            return indices != null && indices.size() > 0 ? indices.get(0) : -1;
        }
    }

    public static final List<NumberContainersTesterCase> NUMBER_CONTAINERS_TESTER_CASES = List.of(
        new NumberContainersTesterCase(
            new String[]{"find", "change", "change", "change", "change", "find", "change", "find"},
            new int[][]{{10}, {2, 10}, {1, 10}, {3, 10}, {5, 10}, {10}, {1, 20}, {10}},
            new Integer[]{-1, null, null, null, null, 1, null, 2}
        )
    );

    @Test
    void testNumberContainers() {
        NumberContainersTester.test(new NumberContainersImpl());
    }

    public interface NumberContainers {

        public void change(int index, int number);

        public int find(int number);
    }

    public static class NumberContainersTester {

        public static void test(NumberContainers numberContainers) {
            for (NumberContainersTesterCase testerCase : NUMBER_CONTAINERS_TESTER_CASES) {
                Assertions.assertArrayEquals(
                    testerCase.expected(),
                    execute(numberContainers, testerCase.operations(), testerCase.data())
                );
            }
        }

        static Integer[] execute(NumberContainers numberContainers, String[] operations, int[][] data) {
            List<Integer> result = new ArrayList<>(operations.length);
            for (int i = 0; i < operations.length; i++) {
                result.add(executeOperation(numberContainers, operations[i], data[i]));
            }
            return result.toArray(new Integer[0]);
        }

        static Integer executeOperation(NumberContainers numberContainers, String operation, int[] data) {
            switch (operation) {
                case "change":
                    numberContainers.change(data[0], data[1]);
                    return null;
                case "find":
                    return numberContainers.find(data[0]);
                default:
                    throw new RuntimeException("Unknown operation: " + operation);
            }
        }

    }

    public record NumberContainersTesterCase(String[] operations, int[][] data, Integer[] expected) {
    }

}
