package trees.splay;

import static org.junit.Assert.assertNotNull;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:44:35 PM 

public class SplayTreeVSHashMapTest {

    SplayTree<Integer, Integer> splayTree;
    Map<Integer, Integer> rbTree;
    
    int MAX = 1000000;
    int factor = 2;
    int step = 1000;
    int Queries = 100000;
    
    public void constructTreeMap(int[] arr, int size) {
        rbTree = new TreeMap<Integer, Integer>();
        for(int a : arr){
            rbTree.put(a, a);
        }
    }
    
    public void constructSplayTree(int[] arr, int size) {
        splayTree = new SplayTree<Integer, Integer>();
        for(int a : arr){
            splayTree.insert(a, a);
        }
    }
    
//    @Test
    public void valuesFromNarrowRangeForHashMap() {
        
        System.out.println("\nRandom sample range : tree map");
        System.out.println("SIZE TIME");
        
        int size = 1000;
        
        Random rnd = new Random();
        
        while ( size <= MAX ){
            
            int[] arr = randomArray(size);
            constructTreeMap(arr, size);
            
            int sample[] = getRandomSample(arr, rnd, (int)( size * 0.05f ) );
            
            long start_t = System.currentTimeMillis();
            for( int i = 0; i < Queries; i++){
                assertNotNull( rbTree.get( sample[ rnd.nextInt(sample.length) ] ) );
            }
            long end_t = System.currentTimeMillis();
            System.out.format("%d %d\n", size, end_t - start_t );

            size += step;
            
        }
    }
    
    @Test
    public void valuesFromNarrowRangeForSplay() {
        
        System.out.println("\nRandom sample range : splay");
        System.out.println("SIZE TIME");
        
        int size = 1000;
        
        Random rnd = new Random();
        
        while(size <= MAX){
            
            int[] arr = randomArray(size);
            constructSplayTree(arr, size);
            
            int sample[] = getRandomSample(arr, rnd, (int)( size * 0.05f ) );
            
            long start_t = System.currentTimeMillis();
            for( int i = 0; i < Queries; i++){
                assertNotNull( splayTree.find( sample[ rnd.nextInt(sample.length) ] ) );
            }
            long end_t = System.currentTimeMillis();
            System.out.format("%d %d\n", size, end_t - start_t );

            size += step;
            
        }
    }

    private int[] getRandomSample(int[] arr, Random rnd, int size) {
        int[] range = new int[ size ];
        
        System.arraycopy(arr, 0, range, 0, size);
        
        for(int i = 0, j = 0; i < size && j < size; i++){
            if( rnd.nextInt(i + 1) == 0 ){
                range[j++] = arr[i];
            }
        }
        return range;
    }

    private final int[] randomArray(int size) {
        int[] arr = new int[size];
        // fill
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }
        //shuffle
        Random rnd = new Random();
        for(int i = size - 1; i >= 0; i--){
            int j = rnd.nextInt(i + 1);
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
        return arr;
    }

}
