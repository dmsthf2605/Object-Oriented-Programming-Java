package lab5.lambda;

/*
public class lambda {
    public static void main(String[] args) {

        //Here is a thread built from Runnable interface
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread using Runnable interface");
            }
        }).start();

        //Here is a thread built from Lambda expression
        new Thread(
                () -> System.out.println("Thread using Lambda expression")
        ).start();

    }
}
*/

/**
 * Lambda expressions example the Java program
 * using predicat ava.util.function.Predicate
 * to filter strings
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambda {

    public static void filter(List<String> list, Predicate<String> predicate) {
        for (String s : list)
            if (predicate.test(s))
                System.out.println(s + " ");
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java is simple", "Python is simpler", "Lambda" );

        System.out.println("\nPrint all strings:");
        filter(list, (s) -> true);

        System.out.println("\nPrint no strings:");
        filter(list, (s) -> false);

        System.out.println("\nPrint only:");
        filter(list, (s) -> s.compareTo("Lambda") == 0);

        System.out.println("\nPrint simple:");
        filter(list, (s) -> s.contains("simple"));
    }
}
