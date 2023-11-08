package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final int MAX_BOUND = 50;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void playGCD() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        Random random = new Random();

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber1 = random.nextInt(MAX_BOUND) + 1;
            int randomNumber2 = random.nextInt(MAX_BOUND) + 1;

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = String.format("Question: %d %d",
                    randomNumber1, randomNumber2);
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = findGCD(randomNumber1, randomNumber2);
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static String findGCD(int number1, int number2) {
        int gcd = 1;

        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return String.valueOf(gcd);
    }
}
