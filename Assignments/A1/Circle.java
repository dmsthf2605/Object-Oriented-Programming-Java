
/** This class creates a shape of type circle */
public class Circle implements Shape {

    /** circle radius */
    private double radius;

    /**
     * Constructor accepts an double r for the radius, throws exception if data is not valid
     * @param r A positive double representing the radius of the circle
     * @throws NegativeException when the value for the radius is negative
     */
    public Circle(double r) throws NegativeException {
        if(r < 0.0)
            throw new NegativeException(getClass().getName() + " - Radius cannot be a negative value!");
        setRadius(r);
    }

    /**
     * get the radius value of the circle
     * @return a double indicating the radius of the circle
     */
    public double getRadius(){
        return radius;
    }

    /**
     * set the radius value of the circle
     * @param r A positive double representing the radius of the circle
     */
    public void setRadius(double r){
        radius = r;
    }

    /**
     * Getting the perimeter of the circle
     * Calculate the perimeter using a lambda expression
     * @return a double indicating the perimeter of the circle
     * */
    public double getPerimeter() {
        Perimeter p = array -> 2.0 * Math.PI * array[0];
        return p.get(getRadius());
    }

    /**
     * Returning a string of the variable in the circle
     * @return a String indicating the radius of the circle
     * */
    @Override
    public String toString(){
        return "Circle {r=" + getRadius() +"} Perimeter = " + getPerimeter();
    }

    /**
     * Unique hashCode
     * @return a unique integer hashCode
     * */
    @Override
    public int hashCode(){
        int result = 17;
        result = result * 31 + new Double(getRadius()).hashCode();
        return result;
    }

    /**
     * Equals function
     * @return a boolean indicating whether the circles are equal
     * */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Circle)) return false;

        Circle c = (Circle) o;
        if(getRadius() != c.getRadius()) return false;
        return true;
    }
}