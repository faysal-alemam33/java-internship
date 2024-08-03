
public class LibraryItem {

    protected String title;     // unique
    protected String author;
    protected int publicationYear;
    protected static int  count = 0;

//    ---------------------------------------------- Constructors -----------------------------------------------------
    public LibraryItem() {
    }
    public LibraryItem(String title) {
        this.title = title;
    }

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
//        this.available++;
    }

    //---------------------------------------------------- Setters and Getters -----------------------------------------

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) {this.author = author;}

    public int getPublicationYear() {return publicationYear;}

    public void setPublicationYear(int publicationYear) {this.publicationYear = publicationYear;}


    // -------------------------------- methods  ------------------------------------

    public String displayInfo() {
        return "title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", publicationYear='" + this.publicationYear + '\'' ;
    }
}
