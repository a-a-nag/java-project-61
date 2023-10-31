package hexlet.code;
import java.util.Scanner;

public class Engine {
    private static int countVictories = 0;
    public static final int MAX_VICTORIES_TO_FINISH_GAME = 3;
    private static boolean hasAnsweredTheQuestion = true;

    public static void startGame(String gameRule, String[] questions, String[] rightAnswers) {
        Greetings.greet();

        System.out.println(gameRule);

        while (true) {
            printQuestion(questions[getCountVictories()], rightAnswers[getCountVictories()]);

            if (!getHasAnsweredTheQuestion()) {
                return;
            }

            if (getCountVictories() == MAX_VICTORIES_TO_FINISH_GAME) {
                System.out.printf("Congratulations, %s!", Greetings.getUserName());
                return;
            }
        }
    }
    public static void printQuestion(String question, String rightAnswer) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);

        String userAnswer = scanner.next();
        System.out.println("Your answer: " + userAnswer);

        if (userAnswer.equals(rightAnswer)) {
            setHasAnsweredTheQuestion(true);
            setCountVictories();
            System.out.println("Correct!");
        } else {
            setHasAnsweredTheQuestion(false);
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, rightAnswer);
            System.out.printf("Let's try again, %s!", Greetings.getUserName());
        }
    }

    public static int getCountVictories() {
        return countVictories;
    }

    public static void setCountVictories() {
        countVictories++;
    }

    public static boolean getHasAnsweredTheQuestion() {
        return hasAnsweredTheQuestion;
    }

    public static void setHasAnsweredTheQuestion(boolean hasAnswered) {
        hasAnsweredTheQuestion = hasAnswered;
    }
}
