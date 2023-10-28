package hexlet.code;
public class Greetings {
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        User user = new User();
        user.setUserName();

        System.out.println("Hello, " + user.getUserName() + "!");
    }
}
