
/** This class creates a shape of type rectangle */
public class Rectangle implements Shape{

    /** rectangle length, width */
    private double length, width;

    /**
     * Constructor accepts an double for the length and the width, throws exception if data is not valid
     * @param l A positive double representing the length of the rectangle
     * @param w A positive double representing the width of the rectangle
     * @throws NegativeException when the value for the length and the width are negative
     */
    public Rectangle(double l, double w) throws NegativeException{
        if(l < 0.0 || w < 0.0) throw new NegativeException(getClass().getName() + " - length and width cannot be a negative value!");
        setLength(l);
        setWidth(w);
    }

    /**
     * get the length value of the rectangle
     * @return a double indicating the length of the rectangle
     */
    public double getLength(){
        return length;
    }

    /**
     * set the length value of the rectangle
     * @param l A positive double representing the length of the rectangle
     */
    public void setLength(double l) {
        length = l;
    }

    /**
     * get the width value of the rectangle
     * @return a double indicating the width of the rectangle
     */
    public double getWidth(){
        return width;
    }

    /**
     * set the width value of the rectangle
     * @param w A positive double representing the width of the rectangle
     */
    public void setWidth(double w) {
        width = w;
    }

    /**
     * Getting the perimeter of the rectangle
     * Calculate the perimeter using a lambda expression
     * @return a double indicating the perimeter of the rectangle
     * */
    public double getPerimeter(){
        Perimeter p = array -> (2 * array[0]) + (2 * array[1]);
        return p.get(getLength(), getWidth());
    }

    /**
     * Returning a string of the variable in the rectangle
     * @return a String indicating the length and width of the rectangle
     * */
    @Override
    public String toString(){
        return "Rectangle {l = " + getLength() + ", w = " + getWidth()
                +"} Perimeter = " + getPerimeter();
    }

    /**
     * Unique hashCode
     * @return a unique integer hashCode
     * */
    @Override
    public int hashCode(){
        int result = 17;
        result = result * 31 + new Double(getLength()).hashCode();
        result = result * 31 + new Double(getWidth()).hashCode();
        return result;
    }

    /**
     * Equals function
     * @return a boolean indicating whether the rectangles are equal
     * */
    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(!(object instanceof Rectangle)) return false;

        Rectangle r = (Rectangle) object;
        if(this.getWidth() != r.getWidth()) return false;
        if(this.getLength() != r.getLength()) return false;

        return true;
    }
}
