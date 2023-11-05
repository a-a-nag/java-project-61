package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final int MAX_BOUND = 100;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;
    public static void solveExpression() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        Random random = new Random();

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber1 = random.nextInt(MAX_BOUND);
            int randomNumber2 = random.nextInt(MAX_BOUND);
            String randomMathematicalOperator = returnRandomMathematicalOperator();

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = String.format("Question: %d %s %d",
                    randomNumber1, randomMathematicalOperator, randomNumber2);
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] =
                    calculateExpression(randomNumber1, randomNumber2, randomMathematicalOperator);
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static String returnRandomMathematicalOperator() {
        Random random = new Random();
        final int bound = 3;
        int randomNumber = random.nextInt(bound);

        String[] mathematicalOperators = {"+", "-", "*"};

        return mathematicalOperators[randomNumber];
    }

    public static String calculateExpression(int number1, int number2, String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                break;
        }

        return String.valueOf(result);
    }
}
