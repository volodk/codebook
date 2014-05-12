package trees.splay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 5:52:45 PM 

public class SplayTest {
    
    SplayTree<Integer, Integer> splay;
    
    int[] arr = {5,2,7,1,4,6};
    
    @Before
    public void setUp(){
        
        splay = new SplayTree<Integer, Integer>();
        
        for(int a : arr){
            splay.insert(a, a);
        }
    }

    @Test
    public void print() {
        splay.print();
        assertTrue( splay.isBST( splay.root) );
    }
    
    @Test
    public void find() {
        assertEquals(7, (int)splay.find(7));
        assertTrue( splay.isBST( splay.root) );
    }
    
    @Test
    public void findNull() {
        assertNull(splay.find(8));
        assertTrue( splay.isBST( splay.root) );
    }
    
    @Test
    public void delete() {
        splay.delete(1);
        assertTrue( splay.isBST( splay.root) );
    }
    
    @Test
    public void deleteRoot() {
        splay.delete(splay.root, 5);
        assertTrue( splay.isBST( splay.root) );
    }
    
    @Test
    public void testSplayProperty(){
        assertTrue( splay.size() > 0);
        
        for(int a : arr){
            int out = splay.find(a);
            assertEquals(a, out);
        }
    }
}
