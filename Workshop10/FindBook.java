import java.util.*;

public class FindBook {
    public static void main(String[] argv){
        Set<String> uniques = new HashSet<>();
        Set<String> dups = new HashSet<>();

        ArrayList<Book> library = new ArrayList<>();

        library.add(new Book("A", "a", 100, 1));
        library.add(new Book("A", "a", 200, 2));
        library.add(new Book("E", "e", 300, 0));

        for(int i = 0; i < library.size(); i++){
            if(!uniques.add(library.get(i).getTitle()))
               dups.add(library.get(i).getTitle());
        }
        uniques.removeAll(dups);
        System.out.println(uniques.toString());
    }
}
