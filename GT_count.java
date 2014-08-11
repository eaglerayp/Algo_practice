/**
 * Created by syshih on 2014/8/11.
 */
public class GT_count {
    /**
     * Given two sorted arrays,this function computes the number of pairs that satisfied f[i]>g[j]
     * @param f  sorted array
     * @param g sorted array
     * @return GT_count of input and compare array
     */
    public static int findGTcount(int[] f,int[]g){
        int GT=0;
        int countmax=f.length;
        int j=0;
        for(int i=0;i<g.length;i++){
            while(g[i]>=f[j]){
                j++;
            }
            GT+=countmax-j;
        }
        return GT;
    }
}
