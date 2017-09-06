package lab2;

public class Staff extends Person implements Talkable{
    private String title;

    public Staff(String fn, String ln, String e, String title){
        super(fn, ln, e);
        this.title = title;
    }

    public void setTitle(String t){
        title = t;
    }

    public String getTitle(){
        return title;
    }

    public void doing(){
        System.out.println("Working as staff!");
    }

    public void say(){
        System.out.println("Hello! My name is " + getfirstName() + " " + getlastName() +
                "and my title is " + getTitle());
    }

    public String toString(){
        return "Staff [title = " + getTitle() +", " + super.toString() + "]";
    }
}
