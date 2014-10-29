/**
 * Created by eagle on 2014/10/29.
 */
public class FACTLOG {
    static long cnrs[]=new long[100];
    static int p_size;
    static int cnrs_index;
    static long mask;
    public static long factlog(int n){
        long x=(1<<n)+1;//2^n+1
        mask=(1<<n)-1;// for computing cni 為了和result做&的mask
        p_size=n;
        cnrs_index=0;
        //cnrs[0] represent for c(n|n-1)n/2  cnrs[1]=c(n/2)(n/4)....
        cnrpower((int) x,n);
        cnrs_index=0;
        return factorial(n);
    }
    public static long cnrpower(long n,int square){
        long temp;
        if(square==1){
            temp= n;
        }
        else if ((square&0x01)!=0){
            temp= n*cnrpower(n,square-1);
        }
        else{
            temp= cnrpower(n,square>>1);
            temp*=temp;
            cnrs[cnrs_index++]=(temp>>((square>>1)*p_size))&mask;
        }
        return temp;
    }
    public static long factorial(int n){
        if(n==1){
            return 1;
        }
        else if ((n & 0x01) == 1) {//odd
            return n * factorial(n - 1);
        } else {//even
            long halffact = factorial(n / 2);
            //System.out.println("n"+n+"half"+halffact);
            //System.out.println("n"+n+"CNR"+CNR_LOG.CNR(n, (n / 2)));
            return cnrs[cnrs_index++] * halffact * halffact;
        }
    }

    public static void main(String [] args)    {
        double starttime,endtime;
        starttime=System.currentTimeMillis();
        System.out.println(factlog(10));
        endtime=System.currentTimeMillis()-starttime;
        System.out.println(endtime/1000);
    }
}
