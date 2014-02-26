import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 1:08:18 PM 

public class DisjointSetTest {

    @Test
    public void test() {
        
        Random rnd = new Random();
        
        int N = 10000;
        
        DisjointSet ds = new DisjointSet(N);
        
        int M = N/2;
        
        for(int q = 0; q < M; q++){
            int a = rnd.nextInt(M);
            int b = rnd.nextInt(M);
            ds.connect(a, b);
        }
        
        for(int q = 0; q < M; q++){
            int a = M + rnd.nextInt(M);
            int b = M + rnd.nextInt(M);
            ds.connect(a, b);
        }
        
        int a = rnd.nextInt(M);
        int b = M + rnd.nextInt(M);
        
        ds.connect(a, b);
        
        a = rnd.nextInt(M);
        b = M + rnd.nextInt(M);
        
        Assert.assertTrue(ds.isConnected(a, b));
        
    }

}
