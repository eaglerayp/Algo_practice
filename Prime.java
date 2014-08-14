import java.util.ArrayList;

/**
 * Created by syshih on 2014/8/14.
 */
public class Prime {
    /**
     * find first N primes
     * @param N
     * @return res   N primes array
     */
    public static int[] findNprimes(int N){
        int []res=new int[N];
        int index=2;
        int num=5;
        int sqrt=3;
        res[0]=2;
        res[1]=3;
        int gap=2;
        while(index<N){
            if(sqrt*sqrt<=num){
                sqrt++;
            }
            boolean isPrime=true;
            outfor:
                for(int i=0;res[i]<sqrt;i++){
                   if(num%res[i]==0){
                       isPrime=false;
                       break outfor;
                   }
                }
            if(isPrime){
                res[index++]=num;
            }
            num+=gap;
            gap=6-gap;
        }
        return res;
    }
}
