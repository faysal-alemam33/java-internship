// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------");

        Magazine m1 = new Magazine("Archoden", "Faysal", 2008);
        Magazine m2 = new Magazine("Barrons", "Ali", 2016);

        DVD dvd1 = new DVD("GTAV", "jhon", 2000);
        DVD dvd2 = new DVD("superman", "sony", 2003);

        Book b1 = new Book("OCA", "Oracle", 1999);
        Book b2 = new Book("PCA", "Oracle", 2020);
        Book b3 = new Book("bad", "unknown", 1900);


        LibrarySystem libSystem = new LibrarySystem();

        libSystem.addItem(b1);
        libSystem.addItem(b2);
        libSystem.removeItem(dvd2);
        libSystem.update(1,b3);

        String check1 = (libSystem.checkAvailability("Archoden"))? "item is available!" : "item not available!";
        String check2 = (libSystem.checkAvailability("OCA"))? "item is available!" : "item not available!";
        System.out.println(check1 + "\n" + check2);
        System.out.println(b3.displayInfo());


    }
}