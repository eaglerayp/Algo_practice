import java.util.Arrays;

/**
 * Created by Eagle on 2015/2/16.
 */
public class Solution {
    public static int singleNumber(int[] A) { //find the only single number in a array (others appear twice in the array)
        int result = 0;
        for (int i : A) result ^= i ;
        return result ;
    }
    public static int firstMissingPositive(int[] A) {// given continuous int , find first missing positive integer
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
    private static long log(long x, int base)
    {
        return (long)(Math.log(x)/Math.log(base)+1e-10);
    }
    private static long[] bitsofint(long n){
        int length=(n==0)?1:(int) Math.floor(log(n,2))+1;
        long [] answer = new long [32];
        long two_product=(long)Math.pow(2,length-1);
        for(int i=length-1;i>=0;i--){
            answer[i]= n/two_product;
            n=(answer[i]==1)?n^two_product:n;
            two_product>>>=1;
        }
        return answer;
    }
    private static long intofbits(long[] n){
        int length= n.length;
        long answer=0;
        long two_product=1;
        for(int a=0;a<length;a++){
            answer+=(n[a]==1)?two_product:0;
            two_product<<=1;
        }
        return answer;
    }
    public static long reverseBits(long n) { //given integer, return integer that its Bits are reversed from the integer
        long[]a=bitsofint(n);
        int length=a.length;
        long[]b=new long [32];
        length--;
        for(int i=0;i<=length;i++){
            b[length-i]=a[i];
        }
        long answer=intofbits(b);
        return answer;
    }
    public static void main(String [] args)    {
       // int singletest[]={2,2,3,6,6,5,5,7,7};
        //int firstMissingPositivetest[]={1};
       // int n=firstMissingPositive(firstMissingPositivetest);
        System.out.println(reverseBits(2147483648L));
       // System.out.println(5^10^5);
    }
}
