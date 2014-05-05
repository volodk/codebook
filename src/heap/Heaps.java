package heap;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:35:43 PM 

@SuppressWarnings("unchecked")
public class Heaps {
    
    public interface Heap <T> {
        void push(T elem);
        T pop();
        T peek();
        int size();
    }
    
    private Heaps(){}
    
    private static class ArrayHeap<T> implements Heap<T>{
        
        private int N = 256;
        private int head = 1, tail = 0;
        private Object[] arr;
        private Comparator<T> comparator;

        public ArrayHeap(Comparator<T> comparator) {
            this.comparator = comparator;
            arr = new Object[N];
        }

        @Override
        public void push(T elem) {
            ensureSize();
            arr[++tail] = elem;
            int i = tail;
            while( i > head && gt( arr[i/2], arr[i] )  ){
                swap(arr, i, i/2);
                i = i / 2;
            }
        }

        @Override
        public T pop() {
            checkIndex();
            Object top = arr[head];
            
            arr[head] = arr[tail];
            arr[tail] = null;   // prevent memory leaks 
            tail -= 1;
            
            int i = head;
            T val;
            while (2 * i < tail && gt(arr[i], val = min(arr[2 * i], arr[2 * i + 1])) || 2 * i <= tail
                    && gt(arr[i], val = min(arr[i], arr[2 * i]))) {
                if( gt( arr[i], val) ){
                    int j = 2 * i + ( eq( arr[2*i], val) ? 0 : 1 );
                    swap(arr, i, j);
                    i = j;
                }
            } 
            
            return (T) top;
        }

        @Override
        public T peek() {
            return (T) arr[head];
        }
        
        @Override
        public int size() { return tail; }
        
        private void checkIndex() {
            if ( tail < 1 ) throw new NoSuchElementException();
        }
        
        private void ensureSize(){
            if( size() == N - 1 ){
                Object buff[] = new Object[2*N];
                System.arraycopy(arr, 0, buff, 0, N);
                arr = buff;
                N = N * 2;
            }
        }
        
        private void swap(Object[] arr, int i, int j){
            Object t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
        
        private T min(Object obj1, Object obj2){ return comparator.compare( (T)obj1, (T)obj2) < 0 ? (T)obj1 : (T)obj2; }
        
        private boolean gt(Object obj1, Object obj2){  return comparator.compare((T)obj1, (T)obj2) > 0;  }
        private boolean eq(Object obj1, Object obj2){  return comparator.compare((T)obj1, (T)obj2) == 0; }
        
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
        Heap<Integer> heap = Heaps.minHeap();
        
        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            heap.push( rnd.nextInt(100) );
        }
        
        while(heap.size() > 0){
            System.out.println(heap.pop());
        }
        
    }
}
