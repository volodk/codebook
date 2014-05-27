package sorts;

import java.util.Arrays;

import arrays.Partition;

public class QuickSort {

    public static void main(String[] args) {
        
        int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };
//        int[] arr = { 3, 5, 2 };
        
        qsort(arr, 0, arr.length);
        
        System.out.println(Arrays.toString(arr));
    }

    private static void qsort(int[] arr, int l, int r) {
        
        if( l < r ){
//            int p = Partition.random(arr, l, r);
            int p = Partition.simple(arr, l, r);
//            int p = Partition.middleOfThree(arr, l, r);
            qsort(arr, l, p);
            qsort(arr, p + 1, r);
        }
        
    }
    
}
