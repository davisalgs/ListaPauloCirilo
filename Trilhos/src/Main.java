import java.util.*;

public class Main {
    static final int MAX = 1000;

    static class Pilha {
        int[] vetor = new int[MAX];
        int topo = -1;
    }

    static void push(Pilha p, int id) {
        p.vetor[++p.topo] = id;
    }

    static void pop(Pilha p) {
        p.topo--;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        
        while (true) {
            int vagoes = scanner.nextInt();
            
            if (vagoes == 0)
               
                break;

            Pilha p = new Pilha();

            
            while (true) {
                p.topo = -1;
                boolean presente = false;
                boolean zero = false;
                int ent = 1;

                for (int i = 0; i < vagoes && !presente && !zero; i++) {
                    int fora = scanner.nextInt();
                    if (fora == 0) {
                        zero = true;
                        break;
                    }

                    while (true) {
                        
                        if (fora == ent) {
                            ent++;
                            break;
                        } else if (fora > ent) {
                            push(p, ent);
                            ent++;
                        } else {
                            if (p.vetor[p.topo] == fora)
                                pop(p);
                            
                                else {
                                presente = true;
                                for (; i < vagoes - 1; i++)
                                    scanner.nextInt();
                            }
                            break;
                        }
                    }
                }

                if (!zero) {
                    if (!presente)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}