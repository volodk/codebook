package heap;

public class Heap {
    
    int N = 100;
    
    int tail = -1;
    int[] arr;
    
    public Heap() {
        arr = new int[N];
    }
    
    public void push(int a){
        arr[++tail] = a;
        balance();
    }
    
    public int pop(){
        if( tail < 0 )
            throw new RuntimeException("Heap is empty");
        
        int top = arr[0];
        arr[0] = arr[tail--];
        if(tail >= 0)
            balance();
       
        return top;
    }
    
    public int size(){
        return tail + 1;
    }
    
    private void balance(){
        int i = tail;
        
        while( arr[i] < arr[ i / 2]){
            swap(i, i/2);
            i /= 2;
        }
    }
    
    private void swap(int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    
    public static void main(String[] args) {
        
        Heap h = new Heap();
        
        h.push(3);
        h.push(1);
        h.push(2);
        
        while( h.size() > 0){
            System.out.println(h.pop());
        }

    }

}
