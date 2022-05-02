package sample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        while(true) {
            boolean modify = false;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    int tmp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = tmp;
                    modify = true;
                }
            }
            if (!modify) {
                break;
            }
        }

        for (int value : values) {
            System.out.println(value);
        }
    }
}

//