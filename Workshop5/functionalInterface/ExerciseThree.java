import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Transform {
    String change(String in);
}

public class ExerciseThree {
    public static List<String> modify(List<String> l, Transform t){
        List<String> result = new ArrayList<>(0);
        for(String s : l)
            result.add(t.change(s));
        return result;
    }

    public static void main(String[] argv){
        List<String> original = Arrays.asList("first", "second", "thrid", "fourth");
        // change each element to contain a exclamation mark at the end
        List<String> c1 = modify(original, s -> s + "!");
        System.out.println(c1);

        // change list element by replacing in every string 'r' with 'x'
        List<String> c2 = modify(original, s -> s.replace('r','x'));
        System.out.println(c2);

        //write every string with upcase letters
        List<String> c3 = modify(original, String::toUpperCase); // or s -> s.toUpperCase()
        System.out.println(c3);
    }
}


