package com.octopusthu.dev.playground;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class JavaPlaygroundTests {
    @Test
    void ifNullBooleanTest() {
        assertThrows(NullPointerException.class, () -> {
            Boolean nullBoolean = null;
            if (nullBoolean) {
                System.out.println("Unexpected!");
            }
        });
    }
}
