package arrays;

import java.util.Arrays;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:36:12 PM 

public class Shuffle {

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        shuffle(arr);
        
        System.out.println(Arrays.toString(arr));

    }

    private static void shuffle(int[] arr) {
        
        Random rnd = new Random();
        
        for( int i = arr.length-1; i > 0; i-- ){
            swap( arr, i, rnd.nextInt(i) );
        }
        
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

}
