package ABC086C;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int n = scanner.nextInt();
            int[] position = {0, 0};
            int baseTime = 0;
            for(int i = 1; i <= n; i++) {
                final int t = scanner.nextInt();
                final int[] dest = {scanner.nextInt(), scanner.nextInt()};

                int distance = Math.abs(position[0] - dest[0]) + Math.abs(position[1] - dest[1]);
                int move = Math.abs(distance - (t - baseTime));
                if ((t - baseTime) < distance|| move % 2 == 1) {
                    System.out.println("No");
                    return;
                }
                position = Arrays.copyOf(dest, 2);
                baseTime = t;
            }       
            System.out.println("Yes");
        }
    }
    
}
