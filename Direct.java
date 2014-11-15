/**
 * Created by eagle on 2014/11/15.
 */
public class Direct {
    public static void direct(int n){
        int size=n*n;
        boolean[] bits = new boolean[size];
        System.out.println("There are "+size+" sets in set of 1 to "+n);
        for(int i=0;i<size;i++){
            for (int j = size-1; j >= 0; j--) {
                bits[j] = (i& (1 << j)) != 0;
            }
            for (int j = size-1; j >= 0; j--) {
               if(bits[j]) System.out.print(j+1+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args)    {
        direct(4);
    }
}
