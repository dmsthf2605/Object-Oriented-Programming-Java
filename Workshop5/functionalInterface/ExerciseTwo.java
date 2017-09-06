package lab5.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* generic version of filter and Predicate that works
   with any version of List objects not just on Strings*/
interface Predicate<T> {
    boolean test(T t);
}

public class ExerciseTwo {

    public static <T> List<T> filter(List<T> ls, Predicate<T> p) {
        List<T> result = new ArrayList<>(0);
        for (T t : ls)
            if (p.test(t))
                result.add(t);
        return result;
    }

    public static void main(String[] args) {
        List<Double> listofDoubles = Arrays.asList(1.0, 2.0, 5.0, 10.0);
        List<Double> sol = filter(listofDoubles, s -> (s % 2 == 0 && s > 0.0));
        System.out.println(sol);
    }
}

