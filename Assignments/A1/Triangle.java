
/** This class creates a shape of type triangle */
public class Triangle implements Shape{

    /** triangle sides */
    private double a, b, c;

    /**
     * Constructor accepts an double for the sides, throws exception if data is not valid
     * @param a A positive double representing the side of the triangle
     * @param b A positive double representing the side of the triangle
     * @param c A positive double representing the side of the triangle
     * @throws NegativeException when the value for the sides are negative
     */
    public Triangle(double a, double b, double c) throws NegativeException{
        if(a < 0.0 || b < 0.0 || c < 0.0) throw new NegativeException(getClass().getName() + " - Sides cannot be a negative value!");
        setA(a);
        setB(b);
        setC(c);
    }

    /**
     * get the side a value of the triangle
     * @return a double indicating the side a of the triangle
     */
    public double getA(){
        return a;
    }

    /**
     * set the side a value of the triangle
     * @param a A positive double representing the side a of the triangle
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * get the side b value of the triangle
     * @return a double indicating the side b of the triangle
     */
    public double getB(){
        return b;
    }

    /**
     * set the length value of the square
     * @param b A positive double representing the side b of the triangle
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * get the side c value of the triangle
     * @return a double indicating the side c of the triangle
     */
    public double getC(){
        return c;
    }

    /**
     * set the side c value of the triangle
     * @param c A positive double representing the side c of the triangle
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Getting the perimeter of the triangle
     * Calculate the perimeter using a lambda expression
     * @return a double indicating the perimeter of the triangle
     * */
    public double getPerimeter(){
        Perimeter p = array -> array[0] + array[1] + array[2];
        return p.get(getA(), getB(), getC());
    }

    /**
     * Returning a string of the variable in the triangle
     * @return a String indicating the sides of the triangle
     * */
    @Override
    public String toString(){
        return "Triangle {a = " + getA() + ", b = " + getB() + ", C = " + getC()
                +"} Perimeter = " + getPerimeter();
    }

    /**
     * Unique hashCode
     * @return a unique integer hashCode
     * */
    @Override
    public int hashCode(){
        int result = 17;
        result = result * 31 + new Double(getA()).hashCode();
        result = result * 31 + new Double(getB()).hashCode();
        result = result * 31 + new Double(getC()).hashCode();
        return result;
    }

    /**
     * Equals function
     * @return a boolean indicating whether the triangles are equal
     * */
    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(!(object instanceof Triangle)) return false;

        Triangle t = (Triangle) object;
        if(this.getA() != t.getA()) return false;
        if(this.getB() != t.getB()) return false;
        if(this.getC() != t.getC()) return false;

        return true;
    }
}
