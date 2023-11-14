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
    private static String missedNumber;

    public static void solveProgression() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = "Question: " + createProgression();
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = missedNumber;
        }
        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static String createProgression() {
        int commonDifference  = Utils.generateRandomInt(FIRST_NUMBER, MAX_PROGRESSION_LENGTH);

        String[] progression = new String[MAX_PROGRESSION_LENGTH];
        progression[0] = String.valueOf(FIRST_NUMBER);

        int nextNumber = FIRST_NUMBER;

        for (int i = 1; i < progression.length; i++) {
            nextNumber = nextNumber + commonDifference;
            progression[i] = String.valueOf(nextNumber);
        }
        return hideElementInProgression(progression);
    }

    public static String hideElementInProgression(String[] progression) {
        int randomIndex = Utils.generateRandomInt(FIRST_NUMBER, MAX_PROGRESSION_LENGTH);

        Progression.missedNumber = progression[randomIndex];

        progression[randomIndex] = "..";

        return convertProgressionToString(progression);
    }

    public static String convertProgressionToString (String[] progression) {
        String newProgression = "";

        for (String element : progression) {
            newProgression = newProgression + element + " ";
        }
        return newProgression.trim();
    }
}
