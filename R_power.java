/**
 * Created by eagle on 2014/8/23.
 */
public class R_power {
    public static long power(long n,int square){
        if(square==1){
            return n;
        }
        else if ((square&0x01)!=0){
            return n*power(n,square-1);
        }
        else{
            long temp=power(n,square>>1);
            return temp*temp;
        }
    }
}
