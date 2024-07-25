public class DVD extends LibraryItem {




    //    ---------------------------------------------- Constructors -----------------------------------------------------

    public DVD() {
    }

    public DVD(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }

    // ----------------------------- methods --------------------------------

    @Override
    public String displayInfo() {
        return "DVD{ " +
                super.displayInfo() +
                " }";
    }




}
