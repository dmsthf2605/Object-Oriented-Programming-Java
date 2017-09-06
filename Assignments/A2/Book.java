import java.util.Date;

/**
 * The Book class implements
 * The Book belong to the library inventory
 * @author  Eunsol lee
 * @Date:   March 31, 2017(Fri)
 */
class Book {

    String           bookName;    // the book name
    int              valueTag;    // an integer between -100 and 100
    Library<Book>    library;     // the library having this book in its inventory
    RentSettings     rs;          // rent settings

    /**
     * constructor that set book name and value tag
     * @param bookName name of the book
     * @param valueTag value tag of ths book
     */
    public Book(String bookName, int valueTag) {
        this.bookName = bookName;
        this.valueTag = valueTag;
    }

    /**
     * setter for RentSettings rs object
     * @param rs rent settings for the book
     */
    public void setRs(RentSettings rs) {
        try {
            this.rs = new RentSettings();
            if(rs != null) {
                this.rs.rentDate = rs.rentDate;
                this.rs.dueDate = rs.dueDate;
                this.rs.borrowed = rs.borrowed;
            } else {
                this.rs = null;
            }
        } catch (DateFormatException e){
            System.out.println("Invalid date format please fix it");
        }
    }

    /**
     * set the library of the book
     * @param library library for the book
     */
    public void setLibrary(Library<Book> library) {
        this.library = library;
    }

    /**
     * get the name of the book
     * @return the book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * get value tag of the book
     * @return the value tag
     */
    public int getValueTag() {
        return valueTag;
    }

    /**
     * getter for RentSettings rs object
     * @return rentSettings
     */
    public RentSettings getRs() {
        RentSettings rs = null;
        rs = this.rs;
        return rs;
    }

    /**
     * get the library have this book
     * @return the library
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * set the rent dates; if dates are not valid catch DateFormatException and return false,
     * if rentDate > dueDate catch RentPeriodException and return false
     * if one of the exceptions occur there is no RentSettings object
     * @param rentDate the request date for the rent
     * @param dueDate  the due date for the rent
     * @param library  the library where this book is belong
     * @return true if book was rented, otherwise return false
     */
    public boolean rentBook(String rentDate, String dueDate, Library<Book> library) {
        RentSettings rs = null;

        try{
            rs = new RentSettings(rentDate, dueDate, library);
            setRs(rs);
            setLibrary(library);
        } catch (DateFormatException e){
            System.out.println("Invalid Date Format! it should be ** MM/dd/yyyy ** ");
            return false;
        } catch (RentPeriodException e){
            System.out.println("Rent date CANNOT be larger than due date");
            return false;
        } catch (NullPointerException e){
            System.out.println("cannot be null");
        }
        return true;
    }

    /**
     * destroy the RentSettings object for this book
     * @param library the library the book is belong
     */
    public void returnBook(Library<Book> library) {
        if(library != null) {
            this.setRs(null);
            this.setLibrary(null);
            Book book = library.findBook(this);
            if (book != null)
                book.setRs(null);
        }
    }

    /**
     * if the book is rented, check when the book will be returned
     * if not, can be rented now (current date)
     * @param library the library hold this book
     * @return the date when this book is available
     */
    public String availableDate(Library<Book> library) {
        return this.isRented(library)? this.getRs().getDueDate() : Helper.getCurrentDate();
    }

     /**
     * if currentDate > dueDate means its overdue
     * @return true if the current date is greater than the due date
     */
    public boolean isBookOverdue() {
        try{
            if(this.rs == null)
                return false;

            if (Helper.timeDifference(Helper.getCurrentDate(), getRs().getDueDate()) < 0)
                return true;

        } catch (DateFormatException e){
            System.out.println("Invalid data format to check the book overdue");
        }
        return false;
    }

    /**
     * check whether the book is rented at a given library or not
     * @param l the library
     * @return 'true' if it's rented, 'false' if it's not rented
     */
    public boolean isRented(Library<Book> l) {
        // if RentSettings are not null, it means the book is borrowed
        return l.findBook(this).getRs() != null? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Book)) return false;
        Book b = (Book) o;
        if(valueTag != b.valueTag) return false;
        if(!bookName.equals(b.bookName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + valueTag;
        result = result * 31 + (bookName != null? bookName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        s = this.bookName() + (this.getRs() == null? "" : " " + this.getRs());
        return s;
    }

    /**
     * get rent settings due date
     * @return the return date of the book
     */
    public String getRsDueDate(){
        return this.getRs().getDueDate();
    }

    /**
     * get rent settings rent date
     * @return the rent request date of the book
     */
    public String getRsRentDate(){
        return this.getRs().getRentDate();
    }

    /**
     * get the name of the book depends on the RentSettings
     * @return bookname and value  tag if the library name is null
     *         otherwise return library name as well
     */
    public String bookName() {
        if(this.getLibrary() == null)
            return "(" + bookName + ", " + valueTag + ')';
        else
            return "(" + bookName + ", " + valueTag + " => " + this.getLibrary().getLibraryName() + ')';
    }

    /**
     * inner class that defines the rented perioad and book availability
     */
    private class RentSettings {
        private String rentDate;          // date when the item is requested
        private String dueDate;           // date when the item must be returned
        private boolean borrowed = false; // true if the item is rented

       /**
         * default ctr
         * @throws DateFormatException if there are wrong date format
         */
        private RentSettings() throws DateFormatException {

        }

        /**
         * private ctr must throw DateFormatException and RentPeriodException
         * @param rentDate the request date for the rent
         * @param dueDate  the due date for the rent
         * @param library  the library where request this rent
         * @throws DateFormatException if the date format is not correct
         * @throws RentPeriodException if the rent date is larger than due date
         */
        private RentSettings(String rentDate, String dueDate, Library<Book> library)
                throws DateFormatException, RentPeriodException {

            /**
             * if rentDate and dueDate is valid, set variables
             * otherwise throw DateFormatException
             */
            if(Helper.isValidDate(dueDate) && Helper.isValidDate(rentDate)){
                if (Helper.timeDifference(rentDate, dueDate) < 0) {
                    throw new RentPeriodException();
                }
                this.setRentDate(rentDate);
                this.setDueDate(dueDate);
                borrowed = true;
                library.findBook(Book.this).setRs(this);
            } else {
                throw new DateFormatException();
            }

        }

        /**
         * set rent date of the book
         * @param rentDate rent date for the book
         */
        public void setRentDate(String rentDate){
            this.rentDate = rentDate;
        }

        /**
         * get rent date of the book
         * @return rent date
         */
        public String getRentDate(){
            return rentDate;
        }

        /**
         * set due date of the book
         * @param dueDate due date for the book
         */
        public void setDueDate(String dueDate){
            this.dueDate = dueDate;
        }

        /**
         * get due date of the book
         * @return due date
         */
        public String getDueDate(){
            return dueDate;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof RentSettings)) return false;
            RentSettings rs = (RentSettings) o;
            if(!dueDate.equals(rs.dueDate)) return false;
            if(!rentDate.equals(rs.rentDate)) return false;
            return true;
        }

        @Override
        public int hashCode(){
            int result = 17;
            result = result * 31 + (dueDate != null? dueDate.hashCode() : 0);
            result = result * 31 + (rentDate != null? rentDate.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "RentSettings (" + getRentDate() + ", " + getDueDate() + ", "
                    + library.libraryName + ", " + borrowed + ")";
        }
    }
}
