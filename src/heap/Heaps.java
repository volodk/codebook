package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:35:43 PM 

public class Heaps {
    
    public interface Heap <T extends Comparable<? super T>> {
        void push(T elem);
        T pop();
        T peek();
        int size();
    }
    
    private Heaps(){}
    
    private static class ArrayHeap<T extends Comparable<? super T>> implements Heap<T>{
        
        private int N = 16;
        private int head = 1, tail = 0;
        private ArrayList<T> arr;
        private Comparator<T> comparator;

        public ArrayHeap(Comparator<T> comparator) {
            this.comparator = comparator;
            arr = new ArrayList<>(N);
            arr.add(null);
        }

        @Override
        public void push(T elem) {
            ensureSize();
            arr.add(elem); tail++;
            int i = tail;
            while( i > head && gt( arr.get(i/2), arr.get(i) )  ){
                swap(arr, i, i/2);
                i = i / 2;
            }
        }

        @Override
        public T pop() {
            checkIndex();
            T top = arr.get(head);
            arr.set( head, arr.get(tail) );
            arr.set( tail, null);   // prevent memory leaks 
            tail--;
            int i = head;
            while( 2 * i <= tail && ( gt(arr.get(i), arr.get( 2*i ) ) || gt( arr.get(i), arr.get( 2*i + 1) ) ) ){
                int k = 0;
                if( 2*i + 1 < tail ){
                    k = lt(arr.get(2*i), arr.get(2*i+1))? 0 : 1;
                }
                int j = 2 * i + k;
                swap(arr, i, j);
                i = j;
            }
            return top;
        }

        @Override
        public T peek() {
            return (T) arr.get(head);
        }
        
        @Override
        public int size() { return tail; }
        
        private void checkIndex() {
            if ( tail < 1 ) throw new NoSuchElementException();
        }
        
        private void ensureSize(){
            if( size() == N - 1 ){
                ArrayList<T> buff = new ArrayList<>(N * 2);
                buff.addAll(arr);
                arr = buff;
                N = N * 2;
            }
        }
        
        private void swap(List<?> arr, int i, int j){
            Collections.swap(arr, i, j);
        }
        
        private static <T extends Comparable<? super T>> boolean lt(T obj1, T obj2){
            return obj1.compareTo(obj2) < 0;
        }
        
        private static <T extends Comparable<? super T>> boolean gt(T obj1, T obj2){
            return obj1.compareTo(obj2) > 0;
        }
        
        private static <T extends Comparable<? super T>> boolean eq(T obj1, T obj2){
            return obj1.compareTo(obj2) == 0;
        }
        
    }
    
    public static <T extends Comparable<? super T>> Heap<T> minHeap(){
        return new ArrayHeap<T>(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
    public static <T extends Comparable<? super T>> Heap<T> maxHeap(){
        return new ArrayHeap<T>(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o2.compareTo(o1);
            }
        });
    }
    
    public static void main(String[] args) {
        Heap<Integer> heap = Heaps.maxHeap();
        
        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            heap.push( rnd.nextInt(100) );
        }
        
        int p = heap.pop();
        System.out.println(p);
        while( heap.size() > 0){
            int c = heap.pop();
            System.out.println(p);
            if(c > p){
                throw new RuntimeException(c + ":" +p);
            } else {
                p = c;
            }
        }
    }
}
