package com.octopusthu.dev.playground;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Test
    void ifElsePrintTest() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        if (System.out.printf("A") == null) {
            System.out.print("A");
        } else {
            System.out.print("B");
        }
        assertEquals("AB", outputStreamCaptor.toString().trim());
    }
}
