import java.io.*;

class Car implements Serializable {
    private String model;
    private String owner;
    private double mileage;
    private String registration;

    public Car(String brand, String name, double k) {
        model = brand;
        owner = name;
        mileage = k;
        registration = "-";
    }

    public String toString() {
        String s = "";
        s += "Model: " + model + " Owner: " + owner + " mileage: " + mileage
                + " Registration: " + registration;
        return s;
    }

    public void getRegistered(String num) {
        registration = num;
    }

}

public class CarSerialize {
    public static void main(String[] args) {
        try {
            Car c, d;
            c = new Car("Toyota Corolla", "ABCD765", 3500);
            System.out.println("serialize the car object: \n" + c);

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("car.dat"));

            out.writeObject(c); // write an object to the file
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    "car.dat"));

            // read an object from the file
            d = (Car) in.readObject(); // casting!!!
            System.out.println("deserialize the car object: \n" + d);
            in.close();

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}