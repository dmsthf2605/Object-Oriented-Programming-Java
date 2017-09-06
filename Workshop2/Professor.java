package lab2;

public class Professor extends Person implements Talkable{
    private String office;

    public Professor(String fn, String ln, String e, String off){
        super(fn, ln, e);
        office = off;
    }

    public void setOffice(String of){
        office = of;
    }

    public String getOffice(){
        return office;
    }

    public void doing(){
        System.out.println("Teaching as professor!");
    }

    public void say(){
        System.out.println("Hello! My name is " + getfirstName() + " " + getlastName() +
                "and I'm in " + getOffice());
    }

    public String toString(){
        return "Faculty [Office = " + getOffice() + ", " + super.toString() + "]";
    }
}
