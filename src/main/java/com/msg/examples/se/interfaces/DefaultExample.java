package com.msg.examples.se.interfaces;

public class DefaultExample {
  public static void main(String[] args) {
    ChildClass childClass = new ChildClass();
    childClass.bah();
  }
}

interface A {
  default void foo() {
    System.out.println("A.foo");
  }
}

interface B {
  default void foo() {
    System.out.println("B.foo");
  }
}

class ChildClass implements A, B {
  public void bah() {
    this.foo();
  }

  @Override
  public void foo() {
    A.super.foo(); //original foo() from A accessed
    B.super.foo(); //original foo() from B accessed
  }

}
