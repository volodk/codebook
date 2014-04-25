package heap;

import java.util.NoSuchElementException;
import java.util.Random;

public class MinHeap {
    
    int N = 16;
    int head = 1, tail = 0;
    int[] arr;
    
    public MinHeap() { arr = new int[N]; }
    
    public void push(int a){
        ensureSize();
        arr[++tail] = a;
        int i = tail;
        while( i > head && arr[ i/2 ] > arr[ i ] ){
            swap(arr, i, i/2);
            i = i / 2;
        }
    }
    
    public int pop(){
        checkIndex();
        int top = arr[head];
        arr[head] = arr[tail--];
        int i = head;
        while( 2 * i <= tail && ( arr[i] > arr[2 * i] || arr[i] > arr[2 * i + 1] ) ){
            int j = 2 * i + ( arr[ 2 * i ] < arr[ 2 * i + 1] ? 0 : 1 ); 
            swap(arr, i, j);
            i = j;
        }
        return top;
    }

    private void checkIndex() {
        if ( tail < 1 ) throw new NoSuchElementException();
    }

    public int size(){ return tail; }
    
    private void ensureSize(){
        if( size() == N - 1 ){
            int[] buff = new int[N * 2];
            System.arraycopy(arr, 0, buff, 0, N);
            arr = buff;
            N = N * 2;
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        
        Random rnd = new Random();

        for(int i = 0; i < 100000; i++){
            h.push( rnd.nextInt() );
        }
        
        int p = h.pop();
        while( h.size() > 0){
            int c = h.pop();
            if(c < p){
                throw new RuntimeException();
            } else {
                p = c;
            }
        }
    }

}
