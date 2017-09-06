import java.util.LinkedList;

/**
 * This Library Class contain the LinkedList of T (books in this case)
 * @author: Eunsol Lee
 * @Date:   March 31, 2017(Fri)
 */
@SuppressWarnings("unchecked")
public class Library<T extends Book> implements MaxTagValue {
    String        libraryName;
    LinkedList<T> books;

    /**
     * constructor of class Library
     * @param libraryName name of this library
     */
    public Library(String libraryName) {
        setLibraryName(libraryName);
        books = new LinkedList<>();
    }

    /**
     * set the name of the library
     * @param libraryName library for this library
     */
    public void setLibraryName(String libraryName){
        this.libraryName = libraryName;
    }

    /**
     * set the book list
     * @param books books that this library contains
     */
    public void setBooks(LinkedList<T> books) {
        this.books = books;
    }

    /**
     * get library name
     * @return library name
     */
    public String getLibraryName(){
        return libraryName;
    }

    /**
     * get the books that this library holds
     * @return book list
     */
    public LinkedList<T> getBooks() {
        return books;
    }

    /**
     * search all the books from a library
     * find the maximum value tag in each library
     * @return maximum value tag
     */
    public int findMaximumValueTag() {
        int maxElement = -100;
        for(int i = 0; i < books.size(); i++){
            if(maxElement < books.get(i).valueTag)
                maxElement = books.get(i).valueTag;
        }
        return maxElement;
    }

    /**
     * add a book to the list of books
     * @param b the book that is added to the LinkedList<Book>
     */
    public void addBooks(T b){
        books.add(b);
    }

    /**
     * find the book in the library and return the book if it finds it
     * otherwise return null
     * @param book the book we are looking for
     * @return the found book in the library
     */
    public T findBook(T book){
        T find = null;
        for(T b : books) {
            if(b.equals((Book) book))
                find = b;
        }
        return find;
    }

    /**
     * Check the book can be rented or not
     * @param wanted       the book that needs to be rented
     * @param requestDate  the date when the book can be rented
     * @param dueDate      the date when the book must be returned to the library
     * @return             true, if the book can be borrowed from this library,
     *                     and false otherwise
     */
    public boolean rentRequest(Book wanted, String requestDate, String dueDate) {

        try {
            Helper.checkDate(requestDate);
            Helper.checkDate(dueDate);

            if(wanted.isRented((Library<Book>) this)){
                String available = wanted.availableDate((Library<Book>) this);

                // if the request date is after the available date the book can be rented
                if(Helper.timeDifference(available, requestDate) > 0){
                    System.out.println(Helper.printAvailable(wanted, requestDate, this));
                    return true;
                }

                System.out.println(Helper.printUnavailable(wanted, requestDate));
                return false;
            } else {
                System.out.println(Helper.printAvailable(wanted, requestDate, this));
            }

        } catch (DateFormatException e) {
            System.out.println(wanted + e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Library)) return false;
        Library l = (Library) o;
        if(!libraryName.equals(l.libraryName)) return false;
        if(!books.equals(l.books)) return false;
        return true;
    }

    @Override
    public String toString() {
        String r = "";
        // print out all the books that this library contains
        for (Book b : getBooks())
            r += b.toString() + "\n";
        return r;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + (libraryName != null? libraryName.hashCode() : 0);
        return result;
    }
}
