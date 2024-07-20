import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaIO {

    public static void main(String[] args) {
        int Counter = 0;
        try (BufferedReader reader = new BufferedReader
                (new FileReader("D:\\BackEnd\\GDSC Java Track\\Tasks\\java-intership\\java\\Exceptions\\JavaIO.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                Counter += words.length;
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("The number of words = " + Counter);
    }
}