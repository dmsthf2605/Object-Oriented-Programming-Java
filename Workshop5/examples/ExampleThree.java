package lab5.examples;// lambda expression version
/*
interface Exam {
    String getExamResult(String name);
}

class Student {
    public String name;
    Student(String s) {name = s;}
}
*/

public class ExampleThree {
    public static String result(Student s, Exam e) {
        return e.getExamResult(s.name);
    }

    public static void main(String[] args) {
        System.out.println(
                result(new Student("John"), n -> { return n + ": Pass"; }));
    }
}