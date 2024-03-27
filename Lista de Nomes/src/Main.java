import java.util.*;
import java.io.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListaLista listaLista = new ListaLista();
        listaLista.add(new ListaString());
        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){

            String nome = scanner.nextLine();
            boolean contains = true;
            int aux = 0;
            for(int j = 0; j < listaLista.size(); j++){
                if(!listaLista.get(j).contains(nome.length()) && contains){
                    listaLista.get(j).add(nome);
                    contains = false;
                }
                aux = j + 1;
            }
            if(contains){
                listaLista.add(new ListaString());
                listaLista.get(aux).add(nome);
            }
        }
        for(int i = 0; i < listaLista.size(); i++){
            listaLista.get(i).sort();
            listaLista.get(i).show();
        }
    }
}

class ListaString {
    private String[] a;
    private int[] tamanho;
    private int ctd;
    public ListaString(){
        this.a = new String[10];
        this.tamanho = new int[10];
        this.ctd = 0;
    
    }
    
    private void createEspace(){
        String[] aux = this.a;
        this.a = new String[this.a.length + this.a.length / 2];
        
        for(int i = 0; i < aux.length; i++){
            this.a[i] = aux[i];
        }
        
        int[] auxtamanho = this.tamanho;
        this.tamanho = new int[this.tamanho.length + this.tamanho.length / 2];
        
        for(int i = 0; i < auxtamanho.length; i++){
            this.tamanho[i] = auxtamanho[i];
        }
    }
    public void add(String s){
       
        try{
            this.a[ctd] = s;
            this.tamanho[ctd] = s.length();
            ctd++;
        }
        catch (IndexOutOfBoundsException e){
            createEspace();
            add(s);
        }
    }
    
    
    public void add(int i, String s){
        try{
            for(int j = ctd; j > i; j--){
                this.a[j] = this.a[j - 1];
                this.tamanho[j] = this.tamanho[j - 1];
            }
            this.a[i] = s;
            this.tamanho[i] = s.length();
            ctd++;
        }
        catch (IndexOutOfBoundsException e){
            createEspace();
            add(i, s);
        }
    }
    public int size(){
        return ctd;
    }
    public void clear(){
        this.ctd = 0;
    }
    public boolean contains(String s){
        for(int i = 0; i < this.ctd; i ++){
            if(this.a[i].equals(s)){
                return true;
            }
        }
        return false;
    }
    public boolean contains(int i){
        for(int j = 0; j < this.ctd; j++){
            if(this.tamanho[j] == i){
                return true;
            }
        }
        return false;
    }
    public void remove(int i){
        try {
            for (int j = i; j < this.ctd; j++) {
                this.a[j] = this.a[j + 1];
                this.tamanho[j] = this.a[j + 1].length();
            }
            this.ctd--;
        }
        catch (ArrayIndexOutOfBoundsException e){
        }
    }
    public String get(int i){
        return this.a[i];
    }
    public int indexOf(String s){
        for(int i = 0; i < this.ctd; i ++){
            if(this.a[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
    public void sort(){
        String aux;
        for(int i = 0; i < this.ctd; i++){
            for(int j = 0; j < this.ctd - 1; j++){
                if(this.a[j].length() > this.a[j + 1].length()){
                    aux = this.a[j];
                    this.a[j] = this.a[j + 1];
                    this.a[j + 1] = aux;
                }
            }
        }
    }
    public void show(){
        for(int i = 0; i < this.ctd; i++){
            if(i + 1 == this.ctd) {
                System.out.print(this.a[i]);
            }
            else {
                System.out.print(this.a[i] + ", ");
            }
        }
        System.out.println();
    }
}

class ListaLista {
    private ListaString[] a; //armazenar os elementos da lista
    private int ctd;
    public ListaLista(){
        this.a = new ListaString[10];
        this.ctd = 0;
    }
    private void createEspace(){
        ListaString[] aux = this.a;
        this.a = new ListaString[this.a.length + this.a.length / 2];
        for(int i = 0; i < aux.length; i++){
            this.a[i] = aux[i];
        }
    }
    public void add(ListaString l){
        try{
            this.a[ctd] = l;
            ctd++;
        }
        catch (IndexOutOfBoundsException e){
            createEspace();
            add(l);
        }
    }
    public void add(int i, ListaString l){
       
        try{
           
            for(int j = ctd; j > i; j--){
                this.a[j] = this.a[j - 1];
            }
            this.a[i] = l;
            ctd++;
        }
        catch (IndexOutOfBoundsException e){
            createEspace();
            add(i, l);
        }
    }
    public int size(){
        return ctd;
    }
    public void clear(){
        this.ctd = 0;
    }
    public boolean contains(ListaString l){
        for(int i = 0; i < this.ctd; i ++){
            if(this.a[i].equals(l)){
                return true;
            }
        }
        return false;
    }
    public void remove(int i){
        try {
            for (int j = i; j < this.ctd; j++) {
                this.a[j] = this.a[j + 1];
            }
            this.ctd--;
        }
        catch (ArrayIndexOutOfBoundsException e){
        }
    }
    public ListaString get(int i){
        return this.a[i];
    }
    public int indexOf(ListaString l){
        for(int i = 0; i < this.ctd; i ++){
            if(this.a[i].equals(l)){
                return i;
            }
        }
        return -1;
    }
}