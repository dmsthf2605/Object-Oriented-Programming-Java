public class Book {
    String title, authors;
    int price, edition;

    public Book(String t, String a, int p, int e){
        title = t;
        authors = a;
        price = p;
        edition = e;
    }

    @Override
    public String toString(){
        return "title = " + title;
    }

    public String getTitle(){
        return title;
    }
}
