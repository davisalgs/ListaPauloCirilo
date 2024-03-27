import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> par = new ArrayList<>();
        List<Integer> imp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            if (value % 2 == 0) {
                par.add(value);
            } else {
                imp.add(value);
            }
        }
        Collections.sort(par);
        Collections.sort(imp, Collections.reverseOrder());

        for (int num : par) {
            System.out.println(num);
        }

        for (int num : imp) {
            System.out.println(num);
        }
    }
}
