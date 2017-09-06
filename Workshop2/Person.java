package lab2;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person(String fn, String ln, String e){
        firstName = fn;
        lastName = ln;
        email = e;
    }

    public void setfirstName(String fn){
        firstName = fn;
    }
    public String getfirstName(){
        return firstName;
    }

    public void setlastName(String ln){
        lastName = ln;
    }
    public String getlastName(){
        return lastName;
    }

    public void setEmail(String e){
        email = e;
    }
    public String getEamil(){
        return email;
    }

    public String toString(){
        return "First Name = " + firstName + ", Last Name = " + lastName + ", Email = " + email;
    }

    public abstract void doing();
}
