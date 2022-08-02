package com.octopusthu.dev.leetcode;

/**
 * @author octopusthu@gmail.com
 */
public class P1114EasyPrintInOrder {
  public P1114EasyPrintInOrder() {
  }

  public void first() {
    print("first");
  }

  public void second() {
    print("second");
  }

  public void third() {
    print("third");
  }

  private void print(String str) {
  }

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
  }

  public void second(Runnable printSecond) throws InterruptedException {

    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
  }

  public void third(Runnable printThird) throws InterruptedException {

    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
