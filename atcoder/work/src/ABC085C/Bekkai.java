package ABC085C;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Bekkai {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            final int expected = scanner.nextInt();
            int amount = scanner.nextInt();
            int[][] patterns = {
                {-5, 1, 0},
                {-10, 0, 1},
                {0, -2, 1},
                {5, -1, 0},
                {10, 0, -1},
                {0, 2, -1},
            };
            
            Set<String> memo = new HashSet<>();
            Queue<String> unchecked = new LinkedList<>();
            String code = join(amount / 1000, 0, 0);
            memo.add(code);
            unchecked.add(code);

            while(!unchecked.isEmpty()) {
                int[] data = toArray(unchecked.poll());

                for (int[] pattern : patterns) {
                    if (!isPositive(pattern, data))  {
                        continue;
                    }
                    code = join(data[0] + pattern[0], data[1] + pattern[1], data[2] + pattern[2]);
                    if (!memo.contains(code)) {
                        if (Arrays.stream(toArray(code)).sum() == expected) {
                            System.out.println(String.format("%d %d %d", data[2] + pattern[2], data[1] + pattern[1], data[0] + pattern[0]));
                            return;
                        }
                        memo.add(code);
                        unchecked.add(code);
                    }
                }
            }
            System.out.println("-1 -1 -1");
        }
    }

    public static boolean isPositive(int[] pattern, int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] + pattern[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static String join(int x, int y, int z) {
        return String.format("%d %d %d", x, y, z);
    }

    public static int[] toArray(String code) {
        return Arrays.stream(code.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
