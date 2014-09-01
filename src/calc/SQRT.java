package calc;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:11:41 PM 

public class SQRT {

    public static void main(String[] args) {
        
//        float y = 0.16f;
        float y = 16f;
        
        System.out.println( sqrt(y) );

    }
    
    public static float sqrt( float y ){
        
        if( y < 0) throw new IllegalArgumentException("Cannot be negative");
        
        double e = 0.000000001f;
        float x0 = y, x1 = 0.0f;
        while( Math.abs( (x0 - x1) / x0 ) > e){
            x0 = (x0 + x1)/2;
            x1 = y / x0;
        }
        return x1;
    }

}
