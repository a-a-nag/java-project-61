package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static void primeGame() {
        String gameRule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[] questions = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];
        String[] rightAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME ];

        Random random = new Random();
        final int bound = 1000;

        for (int i = 0; i < questions.length; i++) {
            int number = random.nextInt(bound);

            questions[i] = "Question: " + number;
            rightAnswers[i] = checkIfNumberIsPrime(number);
        }

        Engine.startGame(gameRule, questions, rightAnswers);
    }
    public static String checkIfNumberIsPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
}
