package com.msg.examples.se.concurrency;

public class ThreadCreator {

  public static void main(String args[]) {
    MyRunnable runnables[] = {new MyRunnable("First runnable"), new MyRunnable("Second runnable")};
    MyThread threads[] = {new MyThread("First thread"), new MyThread("Second thread"), new MyThread("Third thread")};

    for(MyRunnable runnable : runnables) {
      new Thread(runnable).start();
    }

    for(MyThread thread : threads) {
      thread.start();
    }
  }
}

class MyRunnable implements Runnable {

  private String threadName;

  public MyRunnable(String name) {
    threadName = name;
  }

  @Override
  public void run() {
    Thread thread = Thread.currentThread();
    thread.setName(threadName);

    while (true) {
      try {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Thread name: " + getName());
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
