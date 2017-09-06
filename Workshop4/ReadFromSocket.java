import java.io.*;
import java.net.*;

public class ReadFromSocket {

    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("www.google.com", 4321);
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String fromSocket = br.readLine();
            System.out.println(fromSocket);
        } catch (IOException e) {
            System.out.println("Exception : " + e);
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}