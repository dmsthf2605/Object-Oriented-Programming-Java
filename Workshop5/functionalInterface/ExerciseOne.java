import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
interface Predicate {
    boolean test(String s);
}

public class ExerciseOne {

    public static List filter(List<String> ls, Predicate p) {
        List<String> result = new ArrayList<String>(0);
        for (String s : ls)
            if (p.test(s))
                result.add(s);
        return result;
    }

    public static void main(String[] args) {
        List<String> listofStrings = Arrays.asList("first", "second", "third");
        List sol = filter(listofStrings, s -> (s.length() % 2 == 0 && s.contains("s")));
        System.out.println(sol);
    }
*///}