package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    public static void playGCD() {
        String gameRule = "Find the greatest common divisor of given numbers.";

        String[] questions = new String[Engine.victoriesNeededToFinishGame];
        String[] rightAnswers = new String[Engine.victoriesNeededToFinishGame];

        Random random = new Random();
        int bound = 50;

        for (int i = 0; i < questions.length; i++) {
            int randomNumber1 = random.nextInt(bound) + 1;
            int randomNumber2 = random.nextInt(bound) + 1;

            questions[i] = String.format("Question: %d %d", randomNumber1, randomNumber2);
            rightAnswers[i] = findGCD(randomNumber1, randomNumber2);
        }

        Engine.startGame(gameRule, questions, rightAnswers);
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
