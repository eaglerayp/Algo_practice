/**
 * Created by syshih on 2014/8/11.
 */
public class mindist {
    public static int findmindistance(int[] f,int[] g){
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        outloop:
            while(i<f.length&&j<g.length){
                if(f[i]>g[j]){
                    min=(min<f[i]-g[j])?min:f[i]-g[j];
                    j++;
                }else if(f[i]==g[j]){
                    min=0;
                    break outloop;
                }else{
                    min=(min<g[j]-f[i])?min:g[j]-f[i];
                    i++;
                }
            }
        return min;
    }
}
