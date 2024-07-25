public class Magazine extends LibraryItem {




    //    ---------------------------------------------- Constructors -----------------------------------------------------

    public Magazine() {
    }

    public Magazine(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }
// ----------------------------- methods --------------------------------



    @Override
    public String displayInfo() {
        return "Magazine{ " +
                super.displayInfo() +
                " }";
    }

}
