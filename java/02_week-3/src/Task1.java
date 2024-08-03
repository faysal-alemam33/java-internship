import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int flag = 0;
        long[] arr = new long[size];        // size of array must be integer

        for(int i = 0; i < size; i++){
            arr[i] = input.nextLong();
        }
        for (int i = 0; i < 5; i++){
            for(int j = 5; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println("number: " +  arr[i] + " Position of 1st occurrence: " + j);
                    flag++;
                }
            }
        }
        if(flag == 0){
            System.out.println("there is no occurrence");
        }
    }
}