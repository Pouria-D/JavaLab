import java.util.Scanner;

// This program gets an input from user and print it.
public class GetInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        System.out.println("Your input was: " + input);
    }
}
