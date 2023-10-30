package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;
public class Even {
    public static void checkIfNumberIsEven() {
        String gameRule = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[] questions = new String[Engine.victoriesNeededToFinishGame];
        String[] rightAnswers = new String[Engine.victoriesNeededToFinishGame];

        Random random = new Random();
        int bound = 1000;
        for (int i = 0; i < questions.length; i++) {
            int randomNumber = random.nextInt(bound);

            questions[i] = "Question: " + randomNumber;
            rightAnswers[i] = randomNumber % 2 == 0 ? "yes" : "no";
        }
        Engine.startGame(gameRule, questions, rightAnswers);
    }
}