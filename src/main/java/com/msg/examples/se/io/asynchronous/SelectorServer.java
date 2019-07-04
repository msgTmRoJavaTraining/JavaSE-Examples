package com.msg.examples.se.io.asynchronous;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {
  private static final String EXIT_MESSAGE = "EXIT";

  public static void main(String[] args) throws IOException {
    Selector selector = Selector.open();
    ServerSocketChannel serverSocket = ServerSocketChannel.open();
    serverSocket.bind(new InetSocketAddress("localhost", 5454));
    serverSocket.configureBlocking(false);
    serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    ByteBuffer buffer = ByteBuffer.allocate(256);

    while (true) {
      selector.select();
      Set<SelectionKey> selectedKeys = selector.selectedKeys();
      Iterator<SelectionKey> iter = selectedKeys.iterator();
      while (iter.hasNext()) {

        SelectionKey key = iter.next();

        if (key.isAcceptable()) {
          register(selector, serverSocket);
        }

        if (key.isReadable()) {
          answerWithEcho(buffer, key);
        }
        iter.remove();
      }
    }
  }

  private static void answerWithEcho(ByteBuffer buffer, SelectionKey key) throws IOException {
    SocketChannel client = (SocketChannel) key.channel();
    client.read(buffer);
    if (new String(buffer.array()).trim().equals(EXIT_MESSAGE)) {
      client.close();
      System.out.println("Not accepting client messages anymore");
    }

    buffer.flip();
    client.write(buffer);
    buffer.clear();
  }

  private static void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
    SocketChannel client = serverSocket.accept();
    client.configureBlocking(false);
    client.register(selector, SelectionKey.OP_READ);
  }

  public static Process start() throws IOException {
    String javaHome = System.getProperty("java.home");
    String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
    String classpath = System.getProperty("java.class.path");
    String className = SelectorServer.class.getCanonicalName();

    ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

    return builder.start();
  }
}
