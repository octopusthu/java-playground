package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 168. Excel Sheet Column Title
 *
 * @author octopusthu@gmail.com
 * @date 2022/8/2
 */
public class P168_Easy_ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        int remainder = columnNumber % 26;
        char c = (char) (remainder == 0 ? 'Z' : 'A' + remainder - 1);
        int quotient = columnNumber / 26;
        return (quotient == 1 && remainder == 0) || quotient == 0 ? String.valueOf(c)
            : convertToTitle(remainder == 0 ? (quotient - 1) : quotient) + c;
    }

    @Test
    void testConvertToTitle() {
        Assertions.assertEquals(
            "A",
            convertToTitle(1)
        );
        Assertions.assertEquals(
            "AB",
            convertToTitle(28)
        );
        Assertions.assertEquals(
            "ZY",
            convertToTitle(701)
        );
        Assertions.assertEquals(
            "AZ",
            convertToTitle(52)
        );
        Assertions.assertEquals(
            "FXSHRXW",
            convertToTitle(2147483647)
        );
    }
}
