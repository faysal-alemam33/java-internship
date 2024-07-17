public class Book extends LibraryItem {


    //    ---------------------------------------------- Constructors -----------------------------------------------------

    public Book() {
    }

    public Book(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }



    // -------------------------------- methods  ------------------------------------


    @Override
    public String displayInfo() {
        return "Book{ " +
                super.displayInfo() +
                " }";
    }

}
