package chapter3.MyFirstMQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class BrokerServer3 implements Callable<Integer> {


  public static int SERVICE_PORT = 9999;

  private final Socket socket;


  public BrokerServer3(Socket socket) {
    this.socket = socket;
  }


  @Override
  public Integer call() throws Exception {
    try (
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
    ) {
      while (true) {
        String str = in.readLine();
        if (str == null) {
          continue;
        }
        System.out.println("接收到原始数据：" + str);
        if (str.equals("CONSUME")) {
          String message = Broker.consume();
          out.println(message);
          out.flush();
        } else {
          Broker.produce(str);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(SERVICE_PORT);
    while (true) {
      BrokerServer3 brokerServer = new BrokerServer3(server.accept());
      FutureTask<Integer> ft = new FutureTask<>(brokerServer);
      new Thread(ft).start();
    }
  }
}
