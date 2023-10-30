package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    public static void findGCD() {
        String gameRule = "Find the greatest common divisor of given numbers.";

        String[] questions = new String[Engine.victoriesNeededToFinishGame];
        String[] rightAnswers = new String[Engine.victoriesNeededToFinishGame];

        Random random = new Random();
        int bound = 100;

        for (int i = 0; i < questions.length; i++) {
            int randomNumber1 = random.nextInt(bound);
            int randomNumber2 = random.nextInt(bound);

//            int randomNumber1 = 63;
//            int randomNumber2 = 3;

            questions[i] = String.format("Question: %d %d", randomNumber1, randomNumber2);

            int min = Math.min(randomNumber1, randomNumber2);
            int max = Math.max(randomNumber1, randomNumber2);

            if (max % min == 0) {
                rightAnswers[i] = String.valueOf(min);
                break;
            }

            int counter = min;

            while (counter > 0) {
                if (max % counter == 0 && min % counter == 0) {
                    rightAnswers[i] = String.valueOf(counter);
                    break;
                }
                counter--;
            }
        }

        Engine.startGame(gameRule, questions, rightAnswers);
    }
}
