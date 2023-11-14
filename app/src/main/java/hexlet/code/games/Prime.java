package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FROM_MIN = 1;
    private static final int TO_MAX = 1_000;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void primeGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int number = Utils.generateRandomInt(FROM_MIN, TO_MAX);

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + number;
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = checkIfNumberIsPrime(number) ? "yes" : "no";
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static boolean checkIfNumberIsPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
