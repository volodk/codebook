package heap;

import java.lang.reflect.Array;

public class MinHeap {
    
    int N = 16;
    
    int head = 0, tail = -1;
    int[] arr;
    
    @SuppressWarnings("unchecked")
    public MinHeap() {
        arr = new int[N]; 
    }
    
    public void push(int a){
        
        ensureSize();
        
        arr[++tail] = a;
        
        int i = tail;
        while( arr[i] < arr[i/2] ){
            swap(arr, i, i/2);
            i = i / 2;
        }
        
    }
    
    public int pop(){
        if( tail < 0 )
            throw new RuntimeException("Exhausted heap");
        
        int top = arr[head];
        
        arr[head] = arr[tail--];
        
        int i = head;
        
        while( isMinHeap(i) ){
            
            int j = minChildOf(i);
            
            swap(arr, i, j);
            
            i = j;
        }
        
        return top;
    }
    
    private int minChildOf(int i) {
        return 0;
    }

    private boolean isMinHeap(int i) {
        boolean left = 2*i+1 <= tail && arr[i] < arr[2*i+1];
        boolean rigth = 2*i+2 <= tail && arr[i] < arr[2*i+2];
        return left && rigth;
    }

    public int size(){
        return tail + 1;
    }
    
    private void ensureSize(){
        if( tail == N - 1 ){
            doubleInSize(); 
        }
    }
    
    private void doubleInSize(){
        int[] copy = new int[2*N];
        System.arraycopy(arr, 0, copy, 0, N);
        arr = copy;
    }
    
    
    private void swap(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    
    public static void main(String[] args) {
        
        MinHeap h = new MinHeap();
        
        h.push(3);
        h.push(1);
        h.push(2);
        
        while( h.size() > 0){
            System.out.println(h.pop());
        }

    }

}
