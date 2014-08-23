/**
 * Created by eagle on 2014/8/23.
 */
public class I_power {
    public static int power(int n,int square){
        int res=1;
        while (square>0){
            if((square&0x01)==1){
                res*=n;
            }
            n*=n;
            square>>=1;
        }
        return res;
    }
}
