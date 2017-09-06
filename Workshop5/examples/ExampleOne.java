package lab5.examples;// Anonymous class version
/*
interface Exam {
    String getExamResult(String name);
}

class Student {
    public String name;
    Student(String s) {name = s;}
}
*/
public class ExampleOne {

    public static String result(Student s, Exam e) {
        return e.getExamResult(s.name);
    }

    public static void main(String[] args) {
        System.out.println(result(new Student("John"), new Exam() {
            public String getExamResult(String name) {
                return name + ": Pass";
            }
        }));
    }
}
