package sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        
        int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };
        
        qsort(arr, 0, arr.length);
        
        System.out.println(Arrays.toString(arr));
    }

    private static void qsort(int[] arr, int l, int r) {
        
        if( l < r){
            int p = partitioning(arr, l, r);
            qsort(arr, l, p);
            qsort(arr, p + 1, r);
        }
        
    }

    private static int partitioning(int[] arr, int l, int r) {
        
        int pivot = arr[l];
        
        int i = l + 1, j = r-1;
        
        while( i < j){
            while( i < r && arr[i] < pivot) i++;
            while( j > l && arr[j] >= pivot) j--;
            if( i < j){
                swap(arr, i++, j--);
            }
        }
        swap(arr, l, j);
        
        return j;
    }
    
    private static void swap(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
