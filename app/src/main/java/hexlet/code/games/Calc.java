package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final int FROM_MIN = 0;
    private static final int TO_MAX = 100;
    private static final int MAX_COLUMN = 2;
    private static final int QUESTION_COLUMN_NUMBER = 0;
    private static final int RIGHT_ANSWER_COLUMN_NUMBER = 1;
    private static final String[] MATHEMATICAL_OPERATORS = {"+", "-", "*"};

    public static void startCalc() {
        String[][] questionsAndAnswers = new String[Engine.MAX_VICTORIES_TO_FINISH_GAME][MAX_COLUMN];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber1 = Utils.generateRandomInt(FROM_MIN, TO_MAX);
            int randomNumber2 = Utils.generateRandomInt(FROM_MIN, TO_MAX);

            int index = Utils.generateRandomInt(FROM_MIN, MATHEMATICAL_OPERATORS.length);
            String randomMathematicalOperator = MATHEMATICAL_OPERATORS[index];

            questionsAndAnswers[i][QUESTION_COLUMN_NUMBER] = String.format("Question: %d %s %d",
                    randomNumber1, randomMathematicalOperator, randomNumber2);

            int rightAnswer = calculateExpression(randomNumber1, randomNumber2, randomMathematicalOperator);
            questionsAndAnswers[i][RIGHT_ANSWER_COLUMN_NUMBER] = String.valueOf(rightAnswer);
        }

        Engine.startGame(GAME_RULE, questionsAndAnswers);
    }

    public static int calculateExpression(int number1, int number2, String operator) {
        int result;

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
                throw new Error("Unknown operator!");
        }

        return result;
    }
}
