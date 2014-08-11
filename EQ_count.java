/**
 * Created by syshih on 2014/8/11.
 */
public class EQ_count {
    /**
     *
     * @param f sorted array
     * @param g sorted array
     * @return EQ numbers of two arrays' same elements
     */
    public static int findEQcount(int[] f,int[]g){
        int EQ=0;
        int i=0;
        int j=0;
        while(i<f.length&&j<g.length){
            if(f[i]<g[j]){
                i++;
            }else if(f[i]==g[j]){
                EQ++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return EQ;
    }
}
