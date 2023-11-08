package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_BOUND = 1_000;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void checkIfNumberIsEven() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        Random random = new Random();

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber = random.nextInt(MAX_BOUND);

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + randomNumber;
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = isEven(randomNumber) ? "yes" : "no";
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
