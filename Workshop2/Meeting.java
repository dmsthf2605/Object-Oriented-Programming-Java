package lab2;


public class Meeting {

    public static void main(String[] argv){
        Student s1 = new Student("John", "Smith","jsmith@myseneca.ca", "CPD");
        Student s2 = new Student("Colin","Thomas","cthmos@myseneca.ca","CPD");
        Professor p1 = new Professor("Jordan","Anastasiade","jordan.anastasiade@senecacollege.ca","T1034");
        Professor p2 = new Professor("Wei","Song","wei.song@senecacollege.ca","T2099");
        Staff st1 = new Staff("Jack", "Brwon", "jack.brwon@senecacollege.ca","Admin");
        Staff st2 = new Staff("Paul", "Miller", "paul.miller@senecacollege.ca","Technical Support");

        Person[] working = new Person[6];

        working[0] = s1;
        working[1] = s2;
        working[2] = p1;
        working[3] = p2;
        working[4] = st1;
        working[5] = st2;

        for(int i = 0; i < working.length; i++){
            System.out.println(working[i].toString());
            working[i].doing();
            System.out.println();
        }

        Talkable[] meeting = new Talkable[6];
        meeting[0] = s1;
        meeting[1] = s2;
        meeting[2] = p1;
        meeting[3] = p2;
        meeting[4] = st1;
        meeting[5] = st2;

        for(Talkable t : meeting){
            t.say();
            System.out.println();
        }
    }
}
