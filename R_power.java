/**
 * Created by eagle on 2014/8/23.
 */
public class R_power {
    public static long power(long n,int square){
        if(square==1){
            return n;
        }
        else if (square==2){
            return n*n;
        }
        else{
            int divide=square/2;
            return power(n,divide)*power(n,square-divide);
        }
    }
}
