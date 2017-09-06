
/** This class creates a shape of type square */
public class Square implements Shape{

    /** square length */
    private double length;

    /**
     * Constructor accepts an double for the length, throws exception if data is not valid
     * @param l A positive double representing the length of the square
     * @throws NegativeException when the value for the length is negative
     */
    public Square(double l) throws NegativeException{
        if(l < 0.0)
            throw new NegativeException(getClass().getName() + " - Length cannot be a negative value!");
        setLength(l);
    }

    /**
     * get the radius value of the circle
     * @return a double indicating the radius of the circle
     */
    public double getLength(){
        return length;
    }

    /**
     * set the length value of the square
     * @param l A positive double representing the length of the square
     */
    public void setLength(double l){
        length = l;
    }

    /**
     * Getting the perimeter of the square
     * Calculate the perimeter using a lambda expression
     * @return a double indicating the perimeter of the square
     * */
    public double getPerimeter(){
        Perimeter p = array -> 4 * array[0];
        return p.get(getLength());
    }

    /**
     * Returning a string of the variable in the square
     * @return a String indicating the length of the square
     * */
    @Override
    public String toString() {
        return "Square {l = " + getLength() + "} Perimeter = " + getPerimeter();
    }

    /**
     * Unique hashCode
     * @return a unique integer hashCode
     * */
    @Override
    public int hashCode(){
        int result = 17;
        result = result * 31 + new Double(getLength()).hashCode();
        return result;
    }

    /**
     * Equals function
     * @return a boolean indicating whether the squares are equal
     * */
    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(!(object instanceof Square)) return false;

        Square s = (Square) object;
        if(getLength() != s.getLength()) return false;

        return true;
    }
}
