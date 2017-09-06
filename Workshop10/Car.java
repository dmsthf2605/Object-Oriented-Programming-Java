public class Car {
    String brand;
    int mileage;
    String color;

    public Car(String b, int m, String c){
        brand = b;
        mileage = m;
        color = c;
    }

    @Override
    public String toString(){
        return "Car [brand = " + brand + ", mileage = " + mileage + ", color = " + color + "]";
    }
}
