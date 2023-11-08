package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final int MAX_BOUND = 10;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;
    private static String missedNumber;

    public static void solveProgression() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + returnProgression();
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = missedNumber;
        }
        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static String returnProgression() {
        Random random = new Random();

        int firstNumber = random.nextInt(MAX_BOUND);
        int nextNumber = firstNumber;
        int commonDifference = random.nextInt(MAX_BOUND);

        String progression = "";
        int randomIndexPosition = random.nextInt(MAX_PROGRESSION_LENGTH);

        for (int i = 0; i < MAX_PROGRESSION_LENGTH; i++) {
            if (i == 0 && i != randomIndexPosition) {
                progression = progression + firstNumber + " ";
                nextNumber = nextNumber + commonDifference;
                continue;
            }

            if (i == randomIndexPosition) {
                progression = progression + ".." + " ";
                missedNumber = String.valueOf(nextNumber);
                nextNumber = nextNumber + commonDifference;
                continue;
            }

            progression = progression + nextNumber + " ";
            nextNumber += commonDifference;
        }

        return progression.trim();
    }
}
