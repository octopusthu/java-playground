package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author octopusthu@gmail.com
 */
public class P1114EasyPrintInOrderTest {

  @Test
  void testPrintInOrder() {

  }

}

class PrintInOrderThread implements Runnable {
  private final P1114EasyPrintInOrder foo;
  private final int sequence;

  public PrintInOrderThread(P1114EasyPrintInOrder foo, int sequence) {
    this.foo = foo;
    this.sequence = sequence;
  }

  @Override
  public void run() {
    switch (this.sequence) {
      case 1:
        this.foo.first();
        break;
      case 2:
        this.foo.second();
        break;
      case 3:
        this.foo.third();
        break;
      default:
    }
  }
}

