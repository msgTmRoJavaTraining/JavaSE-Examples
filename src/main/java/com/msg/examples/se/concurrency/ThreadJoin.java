package com.msg.examples.se.concurrency;

public class ThreadJoin {

  public static void main(String args[]) {
    T1 t1 = new T1();
    T2 t2 = new T2(t1);

    t1.start();
    t2.start();
  }
}

class T1 extends Thread {

  public T1() {
    setName("T1");

  }

  @Override
  public void run() {
    System.out.println(getName() + " is running.");
    for(int i = 0; i < 5; i++) {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class T2 extends Thread {

  private T1 otherThread;

  public T2(T1 otherThread) {
    setName("T2");
    this.otherThread = otherThread;
  }

  @Override
  public void run() {
    System.out.println(getName() + " waits for thread " + otherThread.getName());
    try {
      otherThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(otherThread.getName() + " has finished.");
    System.out.println(getName() + " has finished.");
  }
}