package chapter3.MyFirstMQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
  /** 作用
   * 负责消息的接收、存储、转发等
   */

  private final static int MAX_SIZE = 3;
  private static ArrayBlockingQueue<String> msgQueue = new ArrayBlockingQueue<>(MAX_SIZE);

  public static void produce(String msg) {
    if (msgQueue.offer(msg)) {
      System.out.println("成功向消息处理中心投递:" + msg + ",当前暂存的消息数量是：" + msgQueue.size());
    } else {
      System.out.println("消息处理中心内暂存的消息达到最大符合，不能再存入消息！");
    }
  }


  public static String consume() {
    String msg = msgQueue.poll();
    if (msg != null) {
      System.out.println("已经消费消息：" + msg + ",当前暂存的消息数量是：" + msgQueue.size());
    } else {
      System.out.println("消息中心内没有消息可提供");
    }
    System.out.println("===============");
    return msg;
  }
}
