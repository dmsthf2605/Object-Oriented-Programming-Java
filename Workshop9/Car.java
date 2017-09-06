import java.io.*;

public class Car implements Serializable {

    private String model;
    private String owner;
    private double mileage;
    private Integer registration;

    public Car( String brand, String name, double k ) {
        model = brand;
        owner = name;
        mileage = k;
        registration = 0;
    }

    public String toString() {
        return "Model: " + model + " Owner: " + owner +
                " mileage: " +  mileage +
                " Registration: " + registration;
    }

    public void getRegistered(Integer plate) {
        registration = plate;
    }
}