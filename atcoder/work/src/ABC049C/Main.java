package ABC049C;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            final String s = scanner.next();
            if (s.matches("^(dream(er)?|erase(r)?)*$")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}