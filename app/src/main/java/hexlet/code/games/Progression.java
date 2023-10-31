package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static String missedNumber;
    public static void solveProgression() {
        String gameRule = "What number is missing in the progression?";

        String[] questions = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];
        String[] rightAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];

        for (int i = 0; i < questions.length; i++) {
            questions[i] = "Question: " + returnProgression();
            rightAnswers[i] = getMissedNumber();
        }

        Engine.startGame(gameRule, questions, rightAnswers);
    }
    public static String returnProgression() {
        Random random = new Random();

        final int bound = 10;
        int firstNumber = random.nextInt(bound);
        int nextNumber = firstNumber;
        int commonDifference = random.nextInt(bound);

        String progression = "";
        final int progressionLength = 10;
        int randomIndexPosition = random.nextInt(progressionLength);

        for (int i = 0; i < progressionLength; i++) {
            if (i == 0 && i != randomIndexPosition) {
                progression = progression + firstNumber + " ";
                nextNumber = nextNumber + commonDifference;
                continue;
            }

            if (i == randomIndexPosition) {
                progression = progression + ".." + " ";
                setMissedNumber(String.valueOf(nextNumber));
                nextNumber = nextNumber + commonDifference;
                continue;
            }

            progression = progression + nextNumber + " ";
            nextNumber += commonDifference;
        }

        return progression.trim();
    }
    public static String getMissedNumber() {
        return missedNumber;
    }

    public static void setMissedNumber(String missedNumber) {
        Progression.missedNumber = missedNumber;
    }
}
