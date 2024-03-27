import java.util.*;


public class Main {
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ListaHash<String> pomekons = new ListaHash<>();
        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){
            pomekons.add(scanner.nextLine());
        }
        
        System.out.println(String.format("Falta(m) %d pomekon(s).", 151 - pomekons.size()));
    }
}
class ListaHash <T>{
    private Object[] m;
    private int contador;

    public ListaHash(){
        this.m = new Object[10];
        this.contador = 0;
    }

    private void createEspace(){
        Object[] aux = this.m;
        this.m = new Object[contador + contador / 2];

        for(int i = 0; i < contador; i++){
            this.m[i] = aux[i];
        }
    }

    public void add(T n){
        try{
            if(!contains(n)) {
                this.m[contador] = n;
                this.contador++;
            }
        }

        catch (IndexOutOfBoundsException e){
            createEspace();
            add(n);
        }
    }
    public int size(){
        return this.contador;
    }
    public void clear(){
        this.contador = 0;
    }
    public boolean contains(T n){
        for(int i = 0; i < this.contador; i ++){
            if(this.m[i].equals(n)){
                return true;
            }
        }
        return false;
    }
    private void remove(int i){
        try {
            for (int j = i; j < this.contador; j++) {
                this.m[j] = this.m[j + 1];
            }
            this.contador--;
        }
       
        catch (ArrayIndexOutOfBoundsException e){
        }
    }

    public void remove(T n){
        if(contains(n)){
            remove(indexOf(n));
        }
    }

    public T get(T n){
        return get(indexOf(n));
    }

    private T get(int i){
        return (T)this.m[i];
    }

    private int indexOf(T n){
        for(int i = 0; i < this.contador; i ++){
            if(this.m[i] == n){
             
                return i;
           
            }
        }
        return -1;
    }
}