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
    public static int firstMissingPositive(int[] A) {
        int max=0;
        int min=Integer.MAX_VALUE;
        int answer=-99;
        if(A.length==0){
            answer=1;
        }
        else {
            for(int i:A){
                if(i>0) {
                    if (i > max)
                        max = i;
                    if (i < min)
                        min = i;
                }
            }
            boolean[] counting=new boolean[max+2];
            for(int i:A){
                if(i>0) {
                    counting[i] = true;
                }
            }
            for(int i=1;i<=max+2;i++){
                if(!counting[i]) {
                    answer=i;
                    break;
                }

            }
        }
        return answer;
    }
    public static void main(String [] args)    {
        int singletest[]={2,2,3,6,6,5,5,7,7};
        int firstMissingPositivetest[]={1};
        int n=firstMissingPositive(firstMissingPositivetest);
        double b=4.0;
        System.out.println(n);
       // System.out.println(5^10^5);
    }
}
