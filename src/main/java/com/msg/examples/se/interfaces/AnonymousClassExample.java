package com.msg.examples.se.interfaces;

class Dog {
  protected String name;

  public Dog(String name) {
    this.name = name;
  }

  public String toString() {
    return "This is a dog: " + this.name;
  }
}

public class AnonymousClassExample {

  public static void main(String[] args) {

    Dog normalDog = new Dog("Tucker");

    Dog goodBoy = new Dog("Rexy") {
      // Overwrites the initial class toString. The other methods remain usable.
      @Override
      public String toString() {
        return "This is a very good boy: " + this.name;
      }
    };

    System.out.println(normalDog);
    System.out.println(goodBoy);
  }

}
