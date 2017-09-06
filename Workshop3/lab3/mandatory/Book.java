package lab3.mandatory;
import java.util.Arrays;

/*
public class Book {
    int isbn;
    int price;

    public Book(int i, int p){
        isbn = i;
        price = p;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        String temp = null;
        return temp;
    }

    //@Override
    //protected  Object clone(){
    //return super.clone();
    //}

    public static void main(String[] argv) {

    }
}
*/

import java.util.Arrays;

public class Book implements Cloneable{
    String title;
    int ISBN;
    int price;

    public Book(String title, int price, int ISBN) {
        this.title = title;
        this.price = price;
        this.ISBN = ISBN;
    }

    public void setTitle(String t){
        title = t;
    }

    public String getTitle(){
        return title;
    }

    public void setISBN(int i){
        ISBN = i;
    }

    public int getISBN(){
        return ISBN;
    }

    public void setPrice(int p){
        price = p;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (ISBN != book.ISBN) return false;
        if (price != book.price) return false;
        if (!title.equals(book.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + price;
        result = 31 * result + ISBN;
        return result;
    }

    @Override
    public String toString(){
        return "Book{" + "Title: " + getTitle() + ", Price: " + getPrice() + ", ISBN: " + getISBN() + "}";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Course", 100, 94825321);
        Book b2 = new Book("EAC Course", 300, 12345678);
        System.out.println(b1.equals(b2));
        System.out.println(b1 == b2);

        try {
            Book c1 = (Book) b1.clone();
            Book c2 = c1;
            System.out.println(c1);
            System.out.println(b1);
            System.out.println(c1.equals(b1));
            System.out.println(c1 == c2);
        } catch (CloneNotSupportedException e){
            System.out.println("Catch " + e.getMessage() + "not cloned");
        }
    }
}
