import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.Vector;
import java.io.*;

public class RegisterClient {
    public static void main(String[] args) {
        Car c = new Car("WV", "Mine", 3.2);
        System.out.println(c);
        try {
            Register r = (Register) Naming.lookup("Wonderful");

            Car cc = r.register(c);
            System.out.println(cc);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}