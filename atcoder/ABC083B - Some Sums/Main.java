import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.add(value);
            total += value;

        }
        Collections.sort(list, (a1, a2) -> {return -1 * ((int)a1 - (int)a2);});

        int a = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += list.get(i);
            }
        }
        System.out.println(total - a);
    }
}