package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    public static String missedNumber;
    public static void solveProgression() {
        String gameRule = "What number is missing in the progression?";

        String[] questions = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];
        String[] rightAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];

        for (int i = 0; i < questions.length; i++) {
            questions[i] = "Question: " + returnProgression();
            rightAnswers[i] = missedNumber;
        }

        Engine.startGame(gameRule, questions, rightAnswers);
    }
    public static String returnProgression() {
        Random random = new Random();

        final int MAX_BOUND = 10;
        int firstNumber = random.nextInt(MAX_BOUND);
        int nextNumber = firstNumber;
        int commonDifference = random.nextInt(MAX_BOUND);

        String progression = "";
        int progressionLength = 10;
        int randomIndexPosition = random.nextInt(progressionLength);

        for (int i = 0; i < progressionLength; i++) {
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
