package hexlet.code;
import java.util.Scanner;

public class Engine {
    private static int countVictories = 0;
    public static final int MAX_VICTORIES_TO_FINISH_GAME = 3;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void startGame(String gameRule, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);

        String userName = "";

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameRule);

        while (countVictories < MAX_VICTORIES_TO_FINISH_GAME) {
            System.out.println(questionsAndAnswers[countVictories][QUESTION_COLUMN_NUMBER]);

            String userAnswer = scanner.next();
            System.out.println("Your answer: " + userAnswer);

            if (userAnswer.equals(questionsAndAnswers[countVictories][RIGHT_ANSWER_COLUMN_NUMBER])) {
                Engine.countVictories++;
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        userAnswer, questionsAndAnswers[countVictories][RIGHT_ANSWER_COLUMN_NUMBER]);
                System.out.printf("Let's try again, %s!", userName);
                break;
            }
        }
        System.out.printf("Congratulations, %s!", userName);
    }
}
