import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a weekday number (1-7): ");
        int weekdayNumber = in.nextInt();
        in.close();

        String weekdayName;
        switch (weekdayNumber) {
            case 1:
                weekdayName = "Monday";
                break;
            case 2:
                weekdayName = "Tuesday";
                break;
            case 3:
                weekdayName = "Wednesday";
                break;
            case 4:
                weekdayName = "Thursday";
                break;
            case 5:
                weekdayName = "Friday";
                break;
            case 6:
                weekdayName = "Saturday";
                break;
            case 7:
                weekdayName = "Sunday";
                break;
            default:
                weekdayName = "Invalid weekday number";
        }

        System.out.println("Weekday name: " + weekdayName);
    }

}
