import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This Libraries Class contain all the libraries (4 library in this case)
 * @author: Eunsol Lee
 * @Date:   March 31, 2017(Fri)
 */
@SuppressWarnings("unchecked")
public class Libraries {

    public Library<Book>[] libraries;  // a collection of libraries of type array
    public int numberOfLibraries;      // number of libraries in collection
    private int c = 0;                 // for adding library to libraries

    /**
     * constructor of class Libraries
     * @param numberOfLibraries the number of libraries
     */
    public Libraries(int numberOfLibraries) {
        this.numberOfLibraries = numberOfLibraries;
        this.libraries = new Library[numberOfLibraries];
    }

    /**
     * get a number of libraries
     * @return int indicates number of libraries
     */
    public int getNumberOfLibraries() {
        return numberOfLibraries;
    }

    /**
     * get a collection of libraries
     * @return library from a collection of libraries
     */
    public Library<Book>[] getLibraries() {
        return libraries;
    }

    /**
     * the method takes two String params
     * it reads the file with fileName and creates an object of type Library
     * where the Library has the name defined by the string libraryName
     * @param libraryName the name of the library
     * @param fileName    the filename of the library
     * @return the built library
     */
    public Library buildLibraryFromFile(String libraryName, String fileName) {
        Library<Book> library = new Library<>(libraryName);
        String path = System.getProperty("user.dir");
        Book book = null;
        String s;

        try (BufferedReader br = new BufferedReader(new FileReader(path + "/src/" + fileName))) {
            // if you run locally on your environment use: new FileReader(path + "/src/" + fileName)
            // new FileReader("./Root/" + fileName))

            // if file is not empty, add books to the library
            while ((s = br.readLine()) != null) {
                String[] tok = s.split(",");
                /**
                 * tok[0]: bookName, * tok[1]: valueTag
                 * skip the lines that are no correctly structured
                 */
                if (tok.length == 2) {
                    book = new Book(tok[0], Integer.parseInt(tok[1]));
                    book.setLibrary(library);
                    library.addBooks(book);
                }
            }

            // Add built library to libraries[]
            if (c < numberOfLibraries) {
                libraries[c] = library;
                c++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return library;
    }

    /**
     * the method returns the first library where the book is found
     * this method checks only if the book is part of the library inventory
     * @param book the book we are looking for
     * @return the first library where contains this book, return null
     */
    public Library<Book> isThereBookInLibraries(Book book) {
        for (Library<Book> library : libraries) {
            if(library.findBook(book) != null){
                return library;
            }
        }
        return null;
    }

    /**
     * find the same book in all libraries
     * @param book the book we are looking for
     * @return the total number of books at libraries
     */
    public int howManyBooks(Book book){
        int books = 0;
        for (Library<Book> library : libraries) {
            if(library.findBook(book) != null){
                books++;
            }
        }
        return books;
    }

    /**
     * Search all libraries for a book that can be rented
     * @param book        the book that needs to be rented
     * @param requestDate the date the book is requested for rent
     * @param dueDate     the due date for the book
     * @return            the first library object where the book is available and can be rented
     *                    if all books are rented returns null
     */
    public Library<Book> rentBookAvailable(Book book, String requestDate, String dueDate) {
        Library<Book> foundLibrary = null;
        try{
            if (Helper.isValidDate(requestDate) && Helper.isValidDate(dueDate)) {
                if (Helper.timeDifference(requestDate, dueDate) < 0) {
                    throw new RentPeriodException("Rent date CANNOT be larger than due date");
                }

                // find the book in all libraries
                for (Library<Book> library : libraries) {
                    if(library.findBook(book) != null){
                        if(!book.isRented(library)) {
                            foundLibrary = library;
                            return foundLibrary;
                        }
                    }
                }
            } else {
                throw new DateFormatException("Invalid Date Format! it should be ** MM/dd/yyyy **");
            }
        } catch (DateFormatException e) {
            System.out.println(e.getMessage());
        } catch (RentPeriodException e) {
            System.out.println(e.getMessage());
        }

        return foundLibrary;
    }

    @Override
    public String toString() {
        String r = "";
        // print out all the library that in the collection
        for (Library l : libraries)
            r += l.toString() + "\n";
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Libraries)) return false;
        Libraries l = (Libraries) o;
        if(numberOfLibraries != l.numberOfLibraries) return false;
        if(!Arrays.equals(libraries, l.libraries)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + numberOfLibraries;
        result = result * 31 + Arrays.hashCode(libraries);
        return result;
    }
}