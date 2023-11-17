package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final int FIRST_NUMBER = 1;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;

    public static void startProgression() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            int commonDifference  = Utils.generateRandomInt(FIRST_NUMBER, MAX_PROGRESSION_LENGTH);
            String[] progression = makeProgression(FIRST_NUMBER, commonDifference, MAX_PROGRESSION_LENGTH);

            int randomIndex = Utils.generateRandomInt(FIRST_NUMBER, MAX_PROGRESSION_LENGTH);
            String missedNumber = progression[randomIndex];

            progression[randomIndex] = "..";

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + String.join(" ", progression);
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = missedNumber;
        }
        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];

        progression[0] = String.valueOf(first);

        for (int i = 1; i < progression.length; i++) {

            int previousNumber = Integer.valueOf(progression[i - 1] );
            progression[i] = String.valueOf(previousNumber+ step);
        }

        return progression;
    }
}