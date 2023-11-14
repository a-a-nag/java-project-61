package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final int FROM_MIN = 1;
    private static final int TO_MAX = 50;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void playGCD() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber1 = Utils.generateRandomInt(FROM_MIN, TO_MAX);
            int randomNumber2 = Utils.generateRandomInt(FROM_MIN, TO_MAX);

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = String.format("Question: %d %d",
                    randomNumber1, randomNumber2);
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] =
                    String.valueOf(findGCD(randomNumber1, randomNumber2));
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static int findGCD(int number1, int number2) {
        int gcd = 1;

        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
