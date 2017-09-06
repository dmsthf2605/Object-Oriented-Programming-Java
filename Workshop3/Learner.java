public class Learner implements Cloneable {

    public String name;
    public Address address;

    public Learner(String n, Address a) {
        name = n;
        address = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Learner c = (Learner) super.clone(); // shallow copying
        c.address = (Address) address.clone(); // deep copying
        return c;
    }

    @Override
    public String toString() {
        return "Learner name= " + name + ", address= " + address ;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address a = new Address("Pont Road", 10);
        Learner learner = new Learner("John", a);
        Learner cloned = null;

        //clone learner
        if(learner instanceof Cloneable){
            cloned = (Learner)learner.clone();
        }
        System.out.println("Learner Object = " + learner);

        // LET US change the address of the clone learner to "Bloor"
        cloned.address.setStreet("Bloor");

        System.out.println("Cloned  Object = " + cloned);
        System.out.println("Learner Object = " + learner);
    }
}