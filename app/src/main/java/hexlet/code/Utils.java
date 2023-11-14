package hexlet.code;

public class Utils {
    public static int generateRandomInt(int from, int to) {
        return (int) ((Math.random() * (to - from)) + from);
    }
}
