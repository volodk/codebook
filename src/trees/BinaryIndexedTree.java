package trees;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:16:38 PM 

public class BinaryIndexedTree {    // a.k.a Fenwick tree
    
    int[] t;
    int N;
    
    public BinaryIndexedTree(int N) {
        t = new int[ this.N = N ];
    }
    
    int sum(int k){
        int ans = 0;
        for(; k >= 0; k = ( k & (k+1) ) - 1)
            ans += t[k];
        return ans;
    }
    
    int sum(int i, int j){
        return sum(j) - sum(i-1);
    }
    
    void update(int k, int delta){
        for(; k < N; k = k | (k+1) )
            t[k] += delta;
    }

    public static void main(String[] args) {
        
        BinaryIndexedTree bit = new BinaryIndexedTree(10);
        
        bit.update(2, 1);
        bit.update(3, 2);
        bit.update(4, 1);
        
        // {0,0,1,0,0,0,0,0,0,0}
        // {0,0,1,2,0,0,0,0,0,0}
        // {0,0,1,2,1,0,0,0,0,0}
                
        System.out.println(bit.sum(2, 4));  // 4

    }

}
