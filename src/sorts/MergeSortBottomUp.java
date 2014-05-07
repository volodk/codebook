package sorts;

import java.util.Arrays;

public class MergeSortBottomUp {

	public static void main(String[] args) {
	    
//	    int[] arr = { 4, 3, 5, 2 , 1, 6, 0, 9 };
	    int[] arr = { 4, 3, 5, 2, 6, 1 };
	    
	    int N = arr.length;
	    
	    int[] buff = new int[N];
	    
	    mergesort(arr, buff, N);

	    System.out.println(Arrays.toString(arr));

    }

    static void mergesort(int[] arr, int[] buff, int N) {
        
        for ( int k = 1; k <= N/2; k += k ){
            for ( int i = 0; i + k < N; i += (k+1) ) {
                merge( buff, arr, i, i + k, i + k, i + k + Math.min(k, N-1) );
            }
            int[] ref = buff;
            buff = arr;
            arr = ref;
        }
    }
    
    static void merge(int[] a, int [] b, int i, int n, int j, int m){
        
        int k = i;
        
        while( i < n && j < m ){
            while( i < n && j < m && b[i] < b[j] ) a[k++] = b[i++];
            while( i < n && j < m && b[i] >= b[j] ) a[k++] = b[j++];
        }
        while( i < n ) a[k++] = b[i++];
        while( j < m ) a[k++] = b[j++];
    }

}
