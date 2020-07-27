import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name of file: ");
        String fileName = in.nextLine();
        WordCount wordCount = new WordCount(fileName);
        
        in.close();

    }
}
