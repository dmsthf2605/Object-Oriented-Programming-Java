import java.util.*;

public class FilterCar {
    ArrayList<Car> cars = new ArrayList<>();

    public FilterCar(){
        cars.add(new Car("Honda", 21000, "White"));
        cars.add(new Car("Audi", 15000, "Black"));
        cars.add(new Car("BMW", 10000, "Red"));
    }


    public void filter(Collection<Car> c) {
        /*for(Iterator<Car> it = c.iterator(); it.hasNext();)
            if (!mile(it.next()))
                it.remove();
        for(Iterator<Car> it = c.iterator(); it.hasNext();)
            if (!color(it.next()))
                it.remove();
        */

        cars.removeIf(car -> (!mile(car)) || (!color(car)));
    }

    private static boolean mile(Car c){
        return (c.mileage > 20000)? false : true;
    }

    private static boolean color(Car c){
        return (c.color == "Red")? false : true;
    }

    public String toString(){ return "New cars: " + cars; }

    public static void main(String[] argv){
        FilterCar fc = new FilterCar();
        fc.filter(fc.cars);
        System.out.println(fc);
    }
}

