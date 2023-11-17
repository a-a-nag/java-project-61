package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();

        System.out.println("Your choice: " + gameNumber);
        System.out.println();

        switch (gameNumber) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.startEven();
                break;
            case "3":
                Calc.startCalc();
                break;
            case "4":
                GCD.startGCD();
                break;
            case "5":
                Progression.startProgression();
                break;
            case "6":
                Prime.startPrime();
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                throw new Error("Unknown number!");
        }
    }
}
