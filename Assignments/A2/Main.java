import java.util.ArrayList;

/**
 * The main class displays Tasks from Task 1 to Task 8
 * @author: Eunsol Lee
 * @Date:   March 31, 2017(Fri)
 */
@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {


        /* TASK 1 - build libraries from files - at least two libraries */
        /**
         * print library and the books from it
         * if the book is not assigned to a library ->(book name, value tag)
         * if the book pertains to a library -> (book name, value tag) => library name) +
         * RentSettings (rent date, due date, library name, library name, borrowed)
         */
        System.out.println("\n\n *" + " TASK 1 " + "*");
        Libraries ls = new Libraries(4);

        /**
         * build libraries from the files
         */
        ls.buildLibraryFromFile("Seneca@York", "YorkLibrary.txt");
        ls.buildLibraryFromFile("Newnham", "NewnhamLibrary.txt");
        ls.buildLibraryFromFile("King", "KingLibrary.txt");
        ls.buildLibraryFromFile("Markham", "MarkhamLibrary.txt");


        /**
         * print library and the books from it
         */
        for(int i = 0; i < ls.getNumberOfLibraries(); i++){
            Library<Book> library = ls.getLibraries()[i];
            System.out.println("Library = " + library.getLibraryName() + "\n" + "[\n" + library +"]\n");
        }



        /* TASK 2 - ask for a book that is not in any library inventory */
        System.out.println("\n\n *" + " TASK 2 " + "*");
        Book book = new Book("C++", 20);
        Library<Book> library = ls.isThereBookInLibraries(book);
        if (library == null)
            System.out.println(Helper.printNonexistent(book));



         /* TASK 3 - ask for a book that is in a library inventory
         *  issue a rent request and print the book Essentials of Database Management
         *  issue the same rent request and print the book
         *  return the book
         *  issue the rent request with new dates and print the book
         */
        System.out.println("\n\n *" + " TASK 3 " + "*");

        book = new Book("Essentials of Database Management",25);
        String requestDate = Helper.getCurrentDate(), dueDate = "06/20/2017";

        /**
         * check whether book is available for the rent or not
         */
        library = ls.rentBookAvailable(book, requestDate, dueDate);

        // if the book is available for rent
        if (library != null) {
            System.out.println("----- First Rent Request -----");
            // issue a rent request and print the book
            library.rentRequest(book, requestDate, dueDate);
            book.rentBook(requestDate, dueDate, library);
            System.out.println("wanted: " + book);
            System.out.println();

            System.out.println("----- Second Rent Request -----");
            // issue the same rent request and print the book
            library.rentRequest(book, requestDate, dueDate);
            book.rentBook(requestDate, dueDate, library);
            System.out.println("wanted: " + book);

            System.out.println("\n----- Return the Book -----");
            // return the book
            book.returnBook(library);
            System.out.println();


            System.out.println("----- Third Rent Request -----");
            dueDate = "06/30/2017";
            // issue the rent request with new dates and print the book
            library.rentRequest(book, requestDate, dueDate);
            book.rentBook(requestDate, dueDate, library);
            System.out.println("wanted: " + book);
        } else {
            if(ls.isThereBookInLibraries(book) == null)
                System.out.println(Helper.printNonexistent(book));
        }



        /* TASK 4 - ask for the same book in all libraries
         * look for the same book in all libraries & return
         * the first library where the book is in the library inventory
         * look for the same book in all libraries & return
         * the first library where the book is available to be borrowed
         * if you can find a library, rent the book from that library
         */
        System.out.println("\n\n *" + " TASK 4 " + "*");

        ArrayList<Library> allLibraries = new ArrayList<>();

        // the first library has the same book
        library = ls.isThereBookInLibraries(book);
        if(library != null){
            System.out.println(library.getLibraryName() + " has a same book\n");
            System.out.println(library);
            allLibraries.add(library);
        } else {
            System.out.println("***** No libraries has this book *****");
        }
        System.out.println();

        // the first library where the book is available
        dueDate = "05/28/2017";
        library = ls.rentBookAvailable(book, requestDate, dueDate);
        if(library != null){
            library.rentRequest(book, requestDate, dueDate);
            book.rentBook(requestDate, dueDate, library);
            allLibraries.add(library);
            System.out.println();
            System.out.println(library);
        } else {
            if(ls.isThereBookInLibraries(book) == null)
                System.out.println("***** No libraries are available for rent *****");
        }



        /* TASK 5 - calculate maximum value tag for each library */
        System.out.println("\n\n *" + " TASK 5 " + "*");
        for(int i = 0; i < ls.numberOfLibraries; i++){
            Library lib = ls.getLibraries()[i];
            System.out.println("Maximum value tag for " + lib.getLibraryName() + " is: " + lib.findMaximumValueTag() );
        }


         /* TASK 6 - inquire about a book - it is available? when does it become available, etc. */
        System.out.println("\n\n *" + " TASK 6 " + "*");
        Library<Book> lib = ls.isThereBookInLibraries(book);
        int books = ls.howManyBooks(book);
        if(lib != null) {
            System.out.println("The book '" + book.bookName + "'");
            System.out.println("Is it borrowed? " + (book.isRented(lib) ? "Yes" : "No"));
            System.out.println("Is it overdue? " + (book.isBookOverdue() ? "Yes" : "No"));
            System.out.println("Could it be found in more than one library? "
                    + (books > 1 ? "Yes" : "No"));
            System.out.println("When can it be borrowed? " + book.availableDate(lib));
            System.out.println();
        } else {
            if(ls.isThereBookInLibraries(book) == null)
                System.out.println(Helper.printNonexistent(book));
        }



        /**TASK 7
         * if the book is rented from all libraries
         * find a library that has this book available closest the requested date
         */
        System.out.println("\n\n *" + " TASK 7 " + "*");
        /**
         * rent book from two more libraries so that all libraries' book are rented
         */
        dueDate = "06/20/2017";
        library = ls.rentBookAvailable(book, requestDate, dueDate);
        if(library != null){
            book.rentBook(requestDate, dueDate, library);
            allLibraries.add(library);
        }

        dueDate = "07/27/2017";
        library = ls.rentBookAvailable(book, requestDate, dueDate);
        if(library != null){
            book.rentBook(requestDate, dueDate, library);
            allLibraries.add(library);
        }

        Library<Book> closest = null;
        long diffDays = 0;

        if(allLibraries.size() != 0) {
            try {
                String availableDate = allLibraries.get(0).findBook(book).availableDate(allLibraries.get(0));
                String currentDate = Helper.getCurrentDate();
                diffDays = Helper.timeDifference(currentDate, availableDate);

                for (int i = 0; i < allLibraries.size(); i++) {
                    Library<Book> l1 = allLibraries.get(i);
                    String rentDue = l1.findBook(book).availableDate(l1);

                    if (Helper.timeDifference(currentDate, rentDue) <= diffDays) {
                        diffDays = Helper.timeDifference(currentDate, rentDue);
                        closest = l1;
                    }
                }
            } catch (DateFormatException e) {
                System.out.println("Invalid Date Format! Please check the format");
            }
        }
        if(closest != null){
            System.out.println(Helper.printAvailable(book, closest.findBook(book).getRsDueDate(), closest));
        } else {
            if(ls.isThereBookInLibraries(book) == null)
                System.out.println(Helper.printNonexistent(book));
        }

        System.out.println("\n\n *" + " TASK 8 " + "*");
        System.out.println("***** LinkedList<Book> is used *****");
    }
}
