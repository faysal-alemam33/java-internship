import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Exceptions {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        int num1, num2;

        do{

            try {
                num1 = input.nextInt(); // valid
                num2 = input.nextInt(); // invalid will goto catch
                break;  // if the input is true(integers) it will break
            }catch (InputMismatchException exc){
                System.out.println("Enter (Only) numbers again: ");
                input.nextLine();       // discard invalid inputs
            }
        }
        while (true);
            System.out.println("the sum is: " + (num1 + num2));
    }
}