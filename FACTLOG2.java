/**
 * Created by eagle on 2014/10/23.
 */
public class FACTLOG2 {
    //using cnr_log to compute
    //by  n!=[n!/ (n/2)!*(n/2)!]  *[(n/2)!]^2 =c n n/2  *[(n/2)!]^2
    public static long factlog2(int n){
        if(n==1){
            return 1;
        }
        else if ((n & 0x01) == 1) {//odd
            return n * factlog2(n - 1);
        } else {//even
            long halffact = factlog2(n / 2);
            //System.out.println("n"+n+"half"+halffact);
            //System.out.println("n"+n+"CNR"+CNR_LOG.CNR(n, (n / 2)));
            return CNR_LOG.CNR(n, (n / 2)) * halffact * halffact;
        }
    }
    public static void main(String [] args)    {
        double starttime,endtime;
        starttime=System.currentTimeMillis();
         System.out.println(factlog2(10));
        endtime=System.currentTimeMillis()-starttime;
        System.out.println(endtime/1000);
    }
}
