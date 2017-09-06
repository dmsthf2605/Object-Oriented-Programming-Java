import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    private String firstName, lastName;
    Integer salary;

    public Employee(String f, String l, Integer s){
        firstName = f;
        lastName = l;
        salary = s;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        if(salary != e.salary) return false;
        return e.firstName.equals(firstName) && e.lastName.equals(lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * salary;
        result = 31 * firstName.hashCode() + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + "." + lastName + " " + salary;
    }

    public int compareTo(Employee e){
        int salCmp = salary.compareTo(e.salary);
        int lastCmp = 0;
        if(salCmp != 0)
            return salCmp;
        else {
            lastCmp = lastName.compareTo(e.lastName);
            return (lastCmp != 0 ? lastCmp : firstName.compareTo(e.firstName));
        }
    }
}
