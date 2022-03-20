package chapter3;

import chapter3.MyFirstMQ.MqClient;

public class ConsumeClient {
  public static void main(String[] args) throws Exception {
    MqClient client = new MqClient();
    String message = client.consume();
    System.out.println("获取的消息为" + message);
  }
}
