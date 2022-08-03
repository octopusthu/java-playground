package com.octopusthu.dev.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P2341_Easy_MaximumNumberOfPairsInArray {

    private int[] numberOfPairs(int[] nums) {
        int[] result = new int[]{0, nums.length};
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                result[0]++;
                result[1] -= 2;
            } else {
                set.add(num);
            }
        }
        return result;
    }

    @Test
    void testNumberOfPairs() {
        for (NumberOfPairsTesterCase testerCase : NUMBER_OF_PAIRS_TESTER_CASES) {
            Assertions.assertArrayEquals(
                testerCase.expected(),
                numberOfPairs(testerCase.nums())
            );
        }
    }

    public static final List<NumberOfPairsTesterCase> NUMBER_OF_PAIRS_TESTER_CASES = List.of(
        new NumberOfPairsTesterCase(
            new int[]{1, 3, 2, 1, 3, 2, 2},
            new int[]{3, 1}
        ),
        new NumberOfPairsTesterCase(
            new int[]{1, 1},
            new int[]{1, 0}
        ),
        new NumberOfPairsTesterCase(
            new int[]{0},
            new int[]{0, 1}
        )
    );

    public record NumberOfPairsTesterCase(int[] nums, int[] expected) {

    }
}
