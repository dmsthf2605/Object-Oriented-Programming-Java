package lab5.examples;// functional interface version


interface Exam {
    String getExamResult(String name);
}

class Student {
    public String name;
    Student(String s) {name = s;}
}


class ExampleTwo {
    public static String result(Student s, Exam e) {
        return e.getExamResult(s.name);
    }

    public static void main(String[] args) {
        Student student = new Student("John");
        Exam exam = s -> {return s + ": Pass";};
        System.out.println(result(student, exam));
    }
}  