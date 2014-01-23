package comb;

import java.util.Arrays;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:08:45 PM 

public class Lex {

	public static void main(String[] args) {
		    
	    int[] last = {5,4,3,2,1};
	    int[] p = {1,2,3,4,5};
	    
	    do{
	        System.out.println(Arrays.toString(p));
	        next_permutation(p);
	    }
		while( !eq( last, p) );

	}
	
	static void next_permutation(int[] p) {
                
    }

    static boolean eq(int[] a, int[] b){
	    if( a.length == a.length ){
	        int i = 0;
	        while( i < a.length ){
	            if(a[i] != b[i])
	                return false;
	            i++;
	        }
	        return true;
	    }
	    return false;
	}
	
	
	static void swap(int[] arr, int i, int j){
		int ch = arr[i]; arr[i] = arr[j]; arr[j] = ch;
	}
	
	static void reverse(int[] str, int i, int j){
        for(; i < j; i++, j--){swap(str, i, j);}
    }


}
