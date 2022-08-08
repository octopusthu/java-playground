package com.octopusthu.dev.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P2341_Easy_MaximumNumberOfPairsInArray {

    private int[] numberOfPairs(int[] nums) {
        int length = nums.length;
        int pairs = 0;
        Map<Integer, Boolean> map = new HashMap<>(length);
        for (int num : nums) {
            boolean odd = Boolean.TRUE.equals(map.get(num));
            if (odd) {
                pairs++;
            }
            map.put(num, !odd);
        }
        return new int[]{pairs, length - pairs * 2};
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
