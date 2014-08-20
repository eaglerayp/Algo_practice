import java.util.HashMap;

/**
 * Created by syshih on 2014/8/20.
 */
public class factor {
    public static HashMap<Integer,Integer> factors(int N){
        HashMap<Integer,Integer> facs=new HashMap<Integer, Integer>();
        int exp=0;
        while(N%2==0){
            N/=2;
            exp++;
        }
        if(exp!=0) {
            facs.put(2, exp);
        }
        int div=3;
        while(N>1){
            exp=0;
            while(N%div==0){
                N/=div;
                exp++;
            }
            if(exp!=0) {
                facs.put(div, exp);
            }
            div+=2;
        }
        return facs;
    }

}
