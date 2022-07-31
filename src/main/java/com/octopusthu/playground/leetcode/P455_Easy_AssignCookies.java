package com.octopusthu.playground.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 455. Assign Cookies
 *
 * @author octopusthu@gmail.com
 * @date 2022/7/27
 */
public class P455_Easy_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        // 1. Sort g[] and s[] in ascending order
        // 2. For each g[i] find the smallest satisfying s[j]
        // 3. Stop when no satisfying s[j] could be found for g[i]

        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int i = 0, j = 0;
        while (i < g.length) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j < s.length) {
                contentChildren++;
                j++;
            }
            if (j == s.length) {
                break;
            }
            i++;
        }
        return contentChildren;
    }

    @Test
    void testFindContentChildren() {
        Assertions.assertEquals(
            1,
            findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})
        );
        Assertions.assertEquals(
            2,
            findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})
        );
    }

}
