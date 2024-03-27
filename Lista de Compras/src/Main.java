import java.util.*;
import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Lista<String> lista;
        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){
            lista = new Lista<>();

            for(String j : scanner.nextLine().split(" ")){
                lista.add(j);
            }
            System.out.println(lista);
        }
    }
}

class Node<P extends Comparable<P>> {
    private P data;
    private Node<P> next;
    private Node<P> previous;


    public Node(P data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public P getData() {
        return data;
    }

    public Node<P> getNext(){
        return next;
    }

    public Node<P> getPrevious(){
        return previous;
    }

    public void setData(P data) {
        this.data = data;
    }

    public void setNext(Node<P> next) {
        this.next = next;
    }

    public void setPrevious(Node<P> previous){
        this.previous = previous;
    }
}

class Lista<P extends Comparable<P>> {
    private Node<P> head;
    private Node<P> tail;
    private int cont;
    private Lista<P> duplic;

    public Lista(){
        head = null;
        tail = null;
        cont = 0;
    }

    public void add(P n){
        if(!contains(n)) {
            Node<P> node = new Node<>(n);

            if (head == null) {
                head = node;
                tail = node;
                cont++;
            } 
            else {
                if (head.getData().compareTo(node.getData()) >= 0) {
                    node.setNext(head);
                    head.setPrevious(node);
                   
                    head = node;
                    cont++;
                } 
                else if (tail.getData().compareTo(node.getData()) <= 0) {
                    node.setPrevious(tail);
                    tail.setNext(node);
                    
                    tail = node;
                    cont++;
                } 
                else {
                    Node<P> aux = head;
                    while (aux.getData().compareTo(node.getData()) <= 0) {
                        aux = aux.getNext();
                    }
                    
                    aux.getPrevious().setNext(node);
                    node.setPrevious(aux.getPrevious());
                    node.setNext(aux);
                    aux.setPrevious(node);
                    
                    cont++;
                }
            }
        }
    }

    public int size(){
        return cont;
    }
    
    public void clear(){
        head = null;
        tail = null;
        cont = 0;
    }

    public boolean contains(P n){
        Node<P> aux = head;

        while (aux != null){
            if(aux.getData().equals(n)){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void remove(P n){
        Node<P> aux = head;
        if(head.getData().equals(n)){
            head = head.getNext();
        }
        else if(tail.getData().equals(n)){
            tail = tail.getPrevious();
        }
        else {
            while(!aux.getData().equals(n)){
                aux = aux.getNext();
            }
            aux.getPrevious().setNext(aux.getNext());
        }
    }

    public void remove(int i){
        if(i == 0){
            head = head.getNext();
        }
        else if(i == cont){
            tail = tail.getPrevious();
        }
        else {
            Node<P> aux = head;

            for(int j = 0; j < i; j++){
                aux = aux.getNext();
            }
            aux.getPrevious().setNext(aux.getNext());
        }
    }

    public P get(int i){
        Node<P> aux = head;

        for(int j = 0; j < i; j++){
            aux = aux.getNext();
        }
        return aux.getData();
    }

    public int indexOf(P n){
        Node<P> aux = head;
        int cont = 0;

        while(aux != null){
            if(aux.getData().equals(n)){
                return cont;
            }
            aux = aux.getNext();
            cont++;
        }
        return -1;
    }

    public Lista<P> getduplic(){
        return duplic;
    }

    @Override
    public String toString(){
        Node<P> aux = head;
        String string = "";
        
        while(aux.getNext() != null){
            string += aux.getData() + " ";
            aux = aux.getNext();
        }
        string += aux.getData();
        return string;
    }
}