package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    public static void solveExpression() {
        String gameRule = "What is the result of the expression?";

        String[] questions = new String[Engine.victoriesNeededToFinishGame];
        String[] rightAnswers = new String[Engine.victoriesNeededToFinishGame];

        Random random = new Random();
        int bound = 1000;

        for (int i = 0; i < questions.length; i++) {
            int randomNumber1 = random.nextInt(bound);
            int randomNumber2 = random.nextInt(bound);
            String randomMathematicalOperator = returnRandomMathematicalOperator();

            questions[i] = String.format("Question: %d %s %d",
                    randomNumber1, randomMathematicalOperator, randomNumber2);

            switch (randomMathematicalOperator) {
                case "+":
                    int sum = randomNumber1 + randomNumber2;
                    rightAnswers[i] = String.valueOf(sum);
                    break;
                case "-":
                    int sub = randomNumber1 - randomNumber2;
                    rightAnswers[i] = String.valueOf(sub);
                    break;
                case "*":
                    int mul = randomNumber1 * randomNumber2;
                    rightAnswers[i] = String.valueOf(mul);
                    break;
                default:
                    break;
            }
        }

        Engine.startGame(gameRule, questions, rightAnswers);
    }

    public static String returnRandomMathematicalOperator() {
        Random random = new Random();
        int bound = 3;
        int randomNumber = random.nextInt(bound);

        String[] mathematicalOperators = {"+", "-", "*"};

        return mathematicalOperators[randomNumber];
    }
}
