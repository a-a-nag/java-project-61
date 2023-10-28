package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void checkIfNumberIsEven() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        User user = new User();
        user.setUserName();

        System.out.println("Hello, " + user.getUserName() + "!");

        int countVictories = 0;
        int victoriesNeededToFinishGame = 3;

        while (true) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

            Random random = new Random();
            int randomNumber = random.nextInt(1000);

            System.out.println("Question: " + randomNumber);

            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.next();
            System.out.println("Your answer: " + userAnswer);

            if (userAnswer.equals(correctAnswer)) {
                countVictories++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. " +
                        "Correct answer was " + "'" + correctAnswer + "'.");
                System.out.println("Let's try again, " + user.getUserName() + "!");
                break;
            }

            if (countVictories == victoriesNeededToFinishGame) {
                System.out.println("Congratulations, " + user.getUserName() + "!");
                break;
            }
        }
    }
}
