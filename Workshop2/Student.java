package lab2;

public class Student extends Person implements Talkable {
    private String pgm;

    public Student(String fn, String ln, String e, String pgm){
        super(fn, ln, e);
        this.pgm = pgm;
    }

    public void setPgm(String pg){
        pgm = pg;
    }

    public String getPgm(){
        return pgm;
    }

    public void doing(){
        System.out.println("Studying as student!");
    }

    public void say(){
        System.out.println("Hello! My name is " + getfirstName() + " " + getlastName() +
                "and I'm in " + getPgm() + " program");
    }

    public String toString(){
        return "Student [Program = " + getPgm() + ", " + super.toString() + "]";
    }
}
