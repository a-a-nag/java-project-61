package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_BOUND = 1_000;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void primeGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        Random random = new Random();

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int number = random.nextInt(MAX_BOUND);

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + number;
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = checkIfNumberIsPrime(number);
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static String checkIfNumberIsPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
