package hexlet.code;
import java.util.Scanner;
public class Greetings {
    public static String userName;
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        Scanner scanner = new Scanner(System.in);

        userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
    }
}
