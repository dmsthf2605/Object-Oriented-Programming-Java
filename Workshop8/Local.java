import java.net.*;

public class Local {
  public static void main(String[] args) {
    try {
      InetAddress me = InetAddress.getLocalHost();
      System.out.println("My name is " + me.getHostName());
      System.out.println("My address is " + me.getHostAddress());
    } catch (UnknownHostException e) {
      System.err.println("Could not determine local address.");
    }
  }
}
