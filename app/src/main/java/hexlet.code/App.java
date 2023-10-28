package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();

        System.out.println("Your choice: " + gameNumber);
        System.out.println();

        switch (gameNumber) {
            case "1":
                Greetings.greet();
                break;
            case "2":
                Even.checkIfNumberIsEven();
                break;
            default:
                break;
        }
    }
}
