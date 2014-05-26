package arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Arrays;
import java.util.Random;

public class Partition {
    
    public static int simple(int[] a, int l, int r){
        int pivot = a[l];
        int i = l+1, j = r-1;
        while( i < j ){
            while( i < j && a[i] <= pivot ) i++;
            while( i < j && a[j] >= pivot ) j--;
            if(i < j){
                swap(a, i++, j--);
            }
        }
        swap( a, l, j-1 );
        return j-1;
    }
    
    public static int random(int[] a, int l, int r){
        Random rnd = new Random();
        swap(a, l, rnd.nextInt( r-l ) );
        int pivot = a[l];
        
        int i = l+1, j = r-1;
        while( i < j ){
            while( i < r && a[i] < pivot ) i++;
            while( j > l && a[j] >= pivot ) j--;
            if(i < j){
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;
    }
    
    public static int middleOfThree(int[] a, int l, int r){
        
        int pivot = mean( a[l], a[ l + (r-l)/2 ], a[r-1] );
        int pIndex;
        if( a[l] == pivot) pIndex = l;
        else if( a[r] == pivot) pIndex = r;
        else pIndex = l + (r-l)/2;
        
        swap(a, l, pIndex);
        
        int i = l+1, j = r-1;
        while( i < j ){
            while( i < j && a[i] < pivot ) i++;
            while( i < j && a[j] >= pivot ) j--;
            if(i < j){
                swap(a, i++, j--);
            }
        }
        swap(a, l, j-1);
        return j-1;
    }
    
    public static void dijkstra3way(int[] a, int l, int r){
    }
    
    public static void sedwik3way(int[] a, int l, int r){
    }
    
    static int mean(int a, int b, int c){
        int mx = max( max(a, b), c);
        int mn = min( min(a,b), c);
        return a ^ b ^ c ^ mx ^ mn;
    }
    
    static void swap(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,1,1,1,1,1,3,3,3,3};
        simple(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
        
//        int[] arr2 = { 4, 3, 5, 2, 1, 6, 0, 9 };
        int[] arr2 = { 4, 3, 5, 2, 1 };
        int p = random(arr2, 0, arr2.length);
        System.out.format("%d: %d ", p, arr2[p]);
        System.out.println(Arrays.toString(arr2));
        
        
        int[] arr3 = {2,1,1,1,1,1,3,3,3,3};
        middleOfThree(arr3, 0, arr.length);
//        System.out.println(Arrays.toString(arr3));
    }
    
}
