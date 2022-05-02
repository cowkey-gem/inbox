package ABC085B;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
    
            Set<Integer> set = new HashSet<>();
    
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
    
            System.out.println(set.size());
        }        
    }
}

