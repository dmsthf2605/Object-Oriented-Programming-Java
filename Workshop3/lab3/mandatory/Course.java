package lab3.mandatory;
import java.util.Arrays;

public class Course implements Cloneable{
    String name;
    Integer id;
    String desc;
    Book[] data;

    public Course(String n, Integer i, String d, Book[] data){
        name = n;
        id = i;
        desc = d;
        this.data = data;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setId(Integer i){
        id = i;
    }

    public int getId(){
        return id;
    }

    public void setDescription(String d){
        desc = d;
    }

    public String getDescription(){
        return desc;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Course)) return false;

        Course c = (Course) o;

        if(id != null? id.equals(c.id) : c.id != null) return false;
        if(name != null ? !name.equals(c.name) : c.name != null) return false;
        if(desc != null ? !desc.equals(c.desc) : c.desc != null) return false;
        if(!Arrays.equals(data, c.data)) return false;

        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Course c = (Course) super.clone();
        for(int i = 0; i < data.length; i++){
            c.data[i] = (Book) data[i].clone();
        }

        return c;
    }

    @Override
    public String toString(){
        String temp;
        temp = "Course{" + "Name: " + getName() + ", Id: " + getId() + ", Description: "
                + getDescription() + ", Course Book : " ;
        for(int i = 0; i < data.length; i++) {
              temp += data[i];
        }
        temp += "}";
        return temp;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Arrays.hashCode(data);
        result = 31 * result + desc.hashCode();
        result = 31 * result + id;
        return result;
    }

    public static void main(String[] argv){
        Book[] b = {new Book("java", 123, 345), new Book("eac", 456, 789)};
        Course c = new Course("JAC", 444, "Java Programming", b);
        System.out.println(c);
        try{
            Course cp1 = (Course) c.clone();
            System.out.println(cp1);
        }catch(CloneNotSupportedException e){
            System.out.println("course " + e.getMessage() + "not clonned");
        }
    }

}
