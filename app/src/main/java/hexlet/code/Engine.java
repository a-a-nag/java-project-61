package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static int countVictories = 0;
    public static int victoriesNeededToFinishGame = 3;
    public static boolean hasAnsweredTheQuestion = true;

    public static void startGame(String gameRule, String[] questions, String[] rightAnswers) {
        Greetings.greet();

        System.out.println(gameRule);

        while (true) {
            printQuestion(questions[countVictories], rightAnswers[countVictories]);

            if (!hasAnsweredTheQuestion) return;

            if (countVictories == victoriesNeededToFinishGame) {
                System.out.printf("Congratulations, %s!", Greetings.userName);
                return;
            }
        }
    }
    public static void printQuestion(String question, String rightAnswer) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);

        String userAnswer = scanner.next();
        System.out.println("Your answer: " + userAnswer);

        if (userAnswer.equals(rightAnswer)) {
            hasAnsweredTheQuestion = true;
            countVictories++;
            System.out.println("Correct!");
        } else {
            hasAnsweredTheQuestion = false;
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, rightAnswer);
            System.out.printf("Let's try again, %s!", Greetings.userName);
        }
    }
}
