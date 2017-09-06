class ByteNegativeException extends Exception {
    public ByteNegativeException(String msg) {
        super(msg);
    }
}

class ByteEvenException extends Exception {
    public ByteEvenException(String msg) {
        super(msg);
    }
}

public class Number {
    public static void main(String[] args) {
        byte value = Byte.parseByte(args[0]);
        try {
            if (value > 127) // java Number 128
                throw new IllegalArgumentException();
            if (value < 0)  // java Number -2
                throw new ByteNegativeException("negative value");
            if (value % 2 == 0) // java Number 2
                throw new ByteEvenException("even value");

        } catch (ByteNegativeException | IllegalArgumentException |
                ByteEvenException e) {
            System.out.println(e.getMessage());
        }
    }
}
