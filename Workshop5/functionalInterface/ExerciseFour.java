package lab5.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Transform<T, R> {
    R change(T in);
}

public class ExerciseFour {
    public static <T,R> List<R> modify(List<T> l, Transform<T, R> t){
        List<R> result = new ArrayList<>(0);
        for(T s : l)
            result.add(t.change(s));
        return result;
    }

    public static void main(String[] argv){
        List<String> original = Arrays.asList("first", "second", "thrid", "fourth");

        List<String> s1 = modify(original, s -> s + "!");
        System.out.println(s1);
        List<String> s2 = modify(original, s -> s.replace('r','x'));
        System.out.println(s2);
        List<String> s3 = modify(original, String::toUpperCase);
        System.out.println(s3);

        // change a list of integers into a list of strings with the binary representation of integers
        List<Integer> listOfIntegers = Arrays.asList(10, 31, 22, -5);
        List<String> c = modify(listOfIntegers, i -> Integer.toBinaryString(i));
        System.out.println(c);
    }
}

