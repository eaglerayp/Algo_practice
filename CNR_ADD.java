/**
 * Created by eagle on 2014/10/17.
 */
public class CNR_ADD {
    public static int Cnr(int n ,int r){
        int c[]=new int [r+1];
        for (int i=0; i <=r;i++){
            c[i]=1;
        }
        for(int i=1;i<=n-r;i++){
            for(int j=1;j<=r;j++){
                c[j]=c[j]+c[j-1];
            }
        }
        return c[r];
    }
    public static void main(String [] args) {
        System.out.println(Cnr(6,1));
    }
}
