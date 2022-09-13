import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y500 = scanner.nextInt();
        int y100 = scanner.nextInt();
        int y50 = scanner.nextInt();
        int total = scanner.nextInt();

        int resultCount = 0;
        for (int _500 = 0; _500 <= y500; _500++) {
            if (_500 * 500 > total) {
                break;
            } 
            for (int _100 = 0; _100 <= y100; _100++) {
                if (_500 * 500 + _100 * 100 > total) {
                    break;
                }
                for (int _50 = 0; _50 <= y50; _50++) {
                    if (_500 * 500 + _100 * 100 + _50 * 50 == total) {
                        resultCount++;
                        break;
                    }
                }
            }   
        }
        System.out.println(resultCount);
    }
}