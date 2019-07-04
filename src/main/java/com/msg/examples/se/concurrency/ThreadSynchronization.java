package com.msg.examples.se.concurrency;

import java.util.Objects;

public class ThreadSynchronization {

  private static Object monitor = new Object();

  public synchronized void synchronizedMethod() {
    // Access shared resources
  }

  public synchronized static void synchronizedStaticMethod() {
    // Access shared resources
  }

  public static void main(String args[]) {

    synchronized (monitor) {
      // Access shared resources
    }

    Objects.hash();

    ThreadSynchronization sync = new ThreadSynchronization();
    sync.synchronizedMethod();

    ThreadSynchronization.synchronizedStaticMethod();
  }
}
