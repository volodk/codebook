package strings;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:50:58 PM 

public class ZAlgorithm {

    public static void main(String[] args) {
        
        String str = "aabadaabcaaba";
        String pat = "aab";
        
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        
        char[] S = (pat + '$' + str).toCharArray();
        
        int[] Z = zAlgorithmen(S);
        
        for( int offset = p.length + 1; offset < Z.length; offset++ ){
            if(Z[offset] == p.length)
                System.out.println(offset);
        }

    }

    private static int[] zAlgorithmen(char[] S) {
        // TODO Auto-generated method stub
        return null;
    }

}
