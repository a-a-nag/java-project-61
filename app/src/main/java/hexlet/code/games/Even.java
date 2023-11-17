package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FROM_MIN = 0;
    private static final int TO_MAX = 1_000;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void startEven() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber = Utils.generateRandomInt(FROM_MIN, TO_MAX);

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + randomNumber;
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = isEven(randomNumber) ? "yes" : "no";
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
