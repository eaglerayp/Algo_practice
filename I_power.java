/**
 * Created by eagle on 2014/8/23.
 */
public class I_power {
    //迴圈式log2N計算power ,  利用n^2迅速逼近目標次方數  , e.g.,  2^9=(2^1)*(2^8)  2^10=(2^2)*(2^8)
    public static long power(long n,int square){
        long res=1;
        while (square>0){
            if((square&0x01)==1){//次方數2^0bit=1的時候 下一次shift會消失,先把記下來
                res*=n;
            }
            n*=n;
            square>>=1;
        }
        return res;
    }
    public static void main(String [] args)    {
        int temp=5;
        temp>>=1;
        power(2,9);
        System.out.println(temp);
        System.out.println(temp&0x01);
    }
}
