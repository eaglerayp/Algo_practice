/**
 * Created by syshih on 2014/8/12.
 */
public class headtail {
    /**
     * find the count of equal prefix sum and postfix sum
     * trick on the first round, 0=0 (count+1)  ,but this loop will not end in postfix=prefix=total sum (count-1) , so it complemented.
     *
     * @param f  all element >0 array  //3,6,2,1,4,5,2
     * @return eqheadtail
     */
    public static int findEQheadtail(int[] f){
        int EQ=0;
        int i=0;
        int j=f.length-1;//last index
        int presum=0;
        int postsum=0;
        while(i<f.length&&j>-1){
            if(presum>postsum){
                postsum+=f[j--];
            }else if(presum==postsum){//equal case
                EQ++;
                postsum+=f[j--];
                presum+=f[i++];
            }else{
                presum+=f[i++];
            }
        }
        return EQ;
    }
}
