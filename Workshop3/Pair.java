import java.nio.ByteBuffer;

public class Pair<F, S> {

    private F first;
    private S second;

    public Pair(F f, S s) {
        first = f;
        second = s;
    }

    public String toString() {
        return "("+ first + ", " + second + ")";
    }

   public static < U, V > Pair < V, U > flip(Pair < U, V > p){
       Pair<V, U> flipped = new Pair<V, U>(p.second, p.first);
       return flipped;
   }

    public static void main(String[] args) {
        Pair<Integer, String> p = new Pair<>(1, "Test");
        System.out.println(p);
       System.out.println(Pair.flip(p));
    }
} 