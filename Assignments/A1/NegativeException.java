/**
 * Custom Exception to catch negative value
 */

public class NegativeException extends Exception{
    public NegativeException(){
        super();
    }

    public NegativeException(String message){
        super(message);
    }
}