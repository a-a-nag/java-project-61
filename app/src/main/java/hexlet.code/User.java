package hexlet.code;
import java.util.Scanner;
public class User {
    private String userName;

    public void setUserName() {
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
    }

    public String getUserName() {
        return userName;
    }
}
