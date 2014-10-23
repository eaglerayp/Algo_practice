import java.util.InputMismatchException;

/**
 * Created by eagle on 2014/10/22.
 */
public class CNR_LOG {
    //computing sigma Cnr*(2^n^r) =(2^n+1)^n
    public static int[] CNRALL(int n){  //return answer[i] represent Cni
        int answer[]=new int[n+1];
        long x=(1<<n)+1;//2^n+1
        long mask=(1<<n)-1;// for computing cni 為了和result做&的mask
        //System.out.println("MASK"+mask);
        //System.out.println("x"+x);
        long result=0;
        result=I_power.power((int) x,n);
        //System.out.println(Long.MAX_VALUE);
        for(int i=0;i<=n;i++){  //result
            answer[i]= (int) (result&mask);
            //System.out.println("RES"+i+":"+result);
            //System.out.println("answer"+i+":"+answer[i]);
            result>>=n;
        }
        return answer;
    }
    public static int CNR(int n,int r){
        int answer[]=CNRALL(n);
        return answer[r];
    }
    public static void main(String [] args)    {
        int test[]=CNRALL(8);
        int n=8;
       // System.out.println(CNR_LOG.CNR(8, 4));
        System.out.println(test[5]);
        System.out.println(test[3]);
    }
}
