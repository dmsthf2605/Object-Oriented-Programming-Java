import java.util.*;

public class AlphabeticalEmployee {
    public static void main(String args[]) {
        Employee[] e = {
                new Employee("John", "Savage", 100),
                new Employee("Eric", "Marx", 200),
                new Employee("Cuong", "Marx", 200),
                new Employee("Oscar", "Savage", 100),
                new Employee("Abe", "Vu", 300) };


        List<Employee> list = Arrays.asList(e);
        Collections.sort(list);
        System.out.println(list);
    }
}
