import java.util.Scanner;

public class Task2 {

    public static long sum(int[] arr){
        long summ = 0L;
        for(int i = 0; i < arr.length; i++){
            summ += arr[i];
        }
        return summ;
    }

    public static double avg(long summ, int sizeOfArr){
        return summ / sizeOfArr;
    }

    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr  = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        long summition = sum(arr);

        System.out.println(summition);
        System.out.println(avg(summition, size));

    }
}
