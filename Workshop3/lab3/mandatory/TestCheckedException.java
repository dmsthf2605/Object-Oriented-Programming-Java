package lab3.mandatory;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestCheckedException {

    public static void test1(String myURL) {
       try {
            URI uri = new URI(myURL);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            }
        } catch(URISyntaxException e){
            System.out.println("URI Syntax Exception - " + e.getMessage());
        } catch (IOException e){
           System.out.println("IO Exception - " + e.getMessage());
        } finally {
           System.out.println("Entered URL : " + myURL);
       }
    }

    public static void test2(String myURL) throws URISyntaxException, IOException{
        URI uri = new URI(myURL);

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(uri);
        }
    }

    public static void main(String[] args) {
        System.out.println("Please enter an URL (e.g. https://ict.senecacollege.ca/): ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String url = sc.nextLine();
        //test1(url);
        try{
            test2(url);
        } catch(URISyntaxException e){
            System.out.println("URI Syntax Exception - " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO Exception - " + e.getMessage());
        }
    }
}
