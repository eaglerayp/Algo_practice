import java.util.Arrays;

/**
 * Created by Eagle on 2015/2/16.
 */
public class Solution {
    public static int singleNumber(int[] A) {
        int result = 0;
        for (int i : A) result ^= i ;
        return result ;
    }
    public static void main(String [] args)    {
        int test[]={2,2,3,6,6,5,5,7,7};
        int n=singleNumber(test);
        double b=4.0;
        System.out.println(n);
       // System.out.println(5^10^5);
    }
}
