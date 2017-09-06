import java.util.*;

public class GuessNumber {
    public static void main(String[] argv){
        // Initialize the list of hard codded number (five digits)
        List num = Arrays.asList("9", "0", "5", "2", "7");

        System.out.println("Please Enter 5 digits with the space: ");
        Scanner sc = new Scanner(System.in);
        String g = sc.nextLine();

        // Convert the user's guess number from a string to list
        List guess = Arrays.asList(g.split(" "));

        int c1 = 0, c2 = 0;

        // Find the number of digits that were correctly included
        for(int i = 0; i < 5; i++) {
           boolean val = num.contains(guess.get(i));
           if (val) c1++;
        }
        System.out.println(c1 + " times were correctly included");

        // Find the number of correctly placed digits by comparing the two lists,
        // element by element, counting each correct placement.
        // (Need two iterators to traverse through guess and solution)
        Iterator<String>  i1 = num.iterator();
        Iterator<String > i2 = guess.iterator();
        while(i1.hasNext() && i2.hasNext()){
            String a = i1.next();
            String b = i2.next();
            if(a.equals(b)){
                c2++;
            }
        }
        System.out.println(c2 + " times were correctly included");
    }
}
