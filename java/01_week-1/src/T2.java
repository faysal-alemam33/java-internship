import java.util.Scanner;

public class T2 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        long num1 = in.nextLong();
        long num2 = in.nextLong();

        System.out.println(num1 + num2 + "\n"
                + (num1 - num2) + "\n"
                + (num1 * num2) + "\n"
                + (num1 / num2)
        );
    }
}
