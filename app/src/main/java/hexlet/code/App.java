package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
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
            case "3":
                Calc.solveExpression();
                break;
            case "4":
                GCD.findGCD();
                break;
            case "5":
                Progression.solveProgression();
                break;
            default:
                break;
        }
    }
}
