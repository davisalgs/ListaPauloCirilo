import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int numCartas = scanner.nextInt();
                if (numCartas == 0) {
                    
                    break;
                }
                Deque<Integer> cartas = new LinkedList<>();
                for (int i = 1; i <= numCartas; i++) {
                    cartas.add(i);
                }
                ArrayList<String> cartaDisc = new ArrayList<>();
                while (cartas.size() > 1) {
                    cartaDisc.add(String.valueOf(cartas.peekFirst()));
                    cartas.removeFirst();
                    cartas.addLast(cartas.peekFirst());
                    cartas.removeFirst();
                }
                System.out.print("Discarded cards: ");
                System.out.print(String.join(", ", cartaDisc));
                System.out.println();
                System.out.println("Remaining card: " + cartas.peekFirst());
            
            } catch (Exception e) {
                break;
            
            }
        }
        scanner.close();
    }
}