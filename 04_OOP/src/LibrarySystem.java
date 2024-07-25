import java.util.ArrayList;
import java.util.List;


public class LibrarySystem {
    private List<LibraryItem> items = new ArrayList<>();


    public void addItem(LibraryItem item){
        items.add(item);
//        item.count++;
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
        System.out.println("Item is removed.");
    }

    public void update(int index, LibraryItem item){
        items.set(index, item);
    }

    public boolean checkAvailability(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return true;
            }
        }
        return false; // Title not found or unavailable
    }




}
