package ABC085C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalSheetCount = scanner.nextInt();
            int totalAmount = scanner.nextInt();

            for (int i = 0; i <= totalSheetCount; i++) {
                if (totalAmount < i * 10000) {
                    break;
                }
                for (int j = 0; j <= totalSheetCount - i; j++) {
                    int k = totalSheetCount - i - j;

                    int amount = i * 10000 + j * 5000 + k * 1000;
                    if (totalAmount < amount) {
                        break;
                    } else if (totalAmount == amount) {
                        System.out.println(String.format("%d %d %d", i, j, k));
                        return;
                    }                
                }
            }
            System.out.println("-1 -1 -1");
        }
    }

}
