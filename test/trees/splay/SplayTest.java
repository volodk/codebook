package trees.splay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 5:52:45 PM 

public class SplayTest {
    
    Splay<Integer, Integer> splay;
    
    int[] arr = {5,2,7,1,4,6,0,9,16,18,23,3,11,10};
    
    @Before
    public void setUp(){
        
        splay = new Splay<Integer, Integer>();
        
        for(int a : arr){
            splay.insert(a, a);
        }
    }

    @Test
    public void print() {
        splay.print();
    }
    
    @Test
    public void find() {
        assertNotNull(splay.find(7));
    }
    
    @Test
    public void findNull() {
        assertNull(splay.find(8));
    }
    
    @Test
    public void delete() {
        splay.delete(splay.root, 1);
        splay.print();
    }
    
    @Test
    public void deleteRoot() {
        splay.delete(splay.root, 5);
        splay.print();
    }
    
    @Test
    public void rotateLeft() {
        splay.rotateLeft(splay.root);
        splay.print();
    }
    
    @Test
    public void rotateRight() {
        splay.rotateRight(splay.root);
        splay.print();
    }
    
    @Test
    public void rotateRightAtNode() {
        splay.rotateRight( splay.find(splay.root, 2) );
        splay.print();
    }
    
    @Test
    public void testBstProperty(){
        System.out.println("splay test");
        
        int size = splay.size(splay.root);
        assertTrue(size > 0);
        
        for(int a : arr){
            splay.find(a);
            int actual = splay.root.value.intValue();
            assertEquals(a, actual);
            
            // ensure that the tree still conforms Binary Search Tree properties
            List<Integer> buff = new ArrayList<Integer>(size);
            splay.inorderKeysDump(splay.root, buff);
            
            for(int i = 1; i < buff.size(); i++)
                assertTrue(buff.get(i-1) < buff.get(i));
            
        }
    }
}
