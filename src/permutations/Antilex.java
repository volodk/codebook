package permutations;

import java.util.Arrays;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:53:48 PM 

public class Antilex {

    public static void main(String[] args) {
        
        int[] last = { 3, 2, 1 };
        int[] p = { 1, 2, 3 };
        
        do {
            System.out.println(Arrays.toString(p));
            next_permutation(p);
        }
        while( !eq( last, p) );

    }
    
    static void next_permutation(int[] p) {
                
    }

    static boolean eq(int[] a, int[] b){
        return Arrays.equals(a, b);
    }
    
    
    static void swap(int[] arr, int i, int j){
        int ch = arr[i]; arr[i] = arr[j]; arr[j] = ch;
    }
    
	static void reverse(int[] str, int i, int j){
		for(; i < j; i++, j--){swap(str, i, j);}
	}

}
