import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Eagle on 2015/2/16.
 */
public class Solution {
    public static int singleNumber(int[] A) { //find the only single number in a array (others appear twice in the array)
        int result = 0;
        for (int i : A) result ^= i ;
        return result ;
    }
    public static int firstMissingPositive(int[] A) {// given continuous int , find first missing positive integer
        int max=0;
        int min=Integer.MAX_VALUE;
        int answer=-99;
        if(A.length==0){
            answer=1;
        }
        else {
            for(int i:A){
                if(i>0) {
                    if (i > max)
                        max = i;
                    if (i < min)
                        min = i;
                }
            }
            boolean[] counting=new boolean[max+2];
            for(int i:A){
                if(i>0) {
                    counting[i] = true;
                }
            }
            for(int i=1;i<=max+2;i++){
                if(!counting[i]) {
                    answer=i;
                    break;
                }

            }
        }
        return answer;
    }
    private static long log(long x, int base)
    {
        return (long)(Math.log(x)/Math.log(base)+1e-10);
    }
    private static long[] bitsofint(long n){
        int length=(n==0)?1:(int) Math.floor(log(n,2))+1;
        long [] answer = new long [32];
        long two_product=(long)Math.pow(2,length-1);
        for(int i=length-1;i>=0;i--){
            answer[i]= n/two_product;
            n=(answer[i]==1)?n^two_product:n;
            two_product>>>=1;
        }
        return answer;
    }
    private static long intofbits(long[] n){
        int length= n.length;
        long answer=0;
        long two_product=1;
        for(int a=0;a<length;a++){
            answer+=(n[a]==1)?two_product:0;
            two_product<<=1;
        }
        return answer;
    }
    public static long reverseBits(long n) { //given integer, return integer that its Bits are reversed from the integer
        long[]a=bitsofint(n);
        int length=a.length;
        long[]b=new long [32];
        length--;
        for(int i=0;i<=length;i++){
            b[length-i]=a[i];
        }
        long answer=intofbits(b);
        return answer;
    }
    public static void rotatebigon(int[] nums, int k) {//rotation array k steps by new array
        int length =nums.length;
        int[] answer=new int [length];
        int count=0;
        while(count<length){
            int index=(count+k)%length;
            answer[index]=nums[count];
            count++;
        }
        for(int i=0;i<length;i++){
            nums[i]=answer[i];
        }
    }
    public static void rotate(int[] nums, int k) {//rotation array k steps by swap
        int length=nums.length;
        if(length>0) {
            k %= nums.length;
            strReverse(nums,0,length-k);
            strReverse(nums,length-k,length);
            strReverse(nums,0,length);
        }
    }
    public static void strReverse(int nums[], int bgn, int end) {
        int lst = end-1;
        while(bgn<lst) {
            int tmp = nums[bgn];
            nums[bgn] = nums[lst];
            nums[lst] = tmp;
            bgn++;
            lst--;
        }
    }

    public static int hammingWeight(long n) {
       /* long[] bits=bitsofint(n);
        int answer=0;
        for(long z:bits){
            answer+=(z==1)?1:0;
        }
        return answer;*/
        int answer=0;
        for(int i=0;i<32;i++){
            answer+=((n&0x01)==1)?1:0;
            n>>>=1;
        }
        return answer;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        /* sorted array version
        int i1=0;
        int j1=1;
        while(i1<numbers.length&&j1<numbers.length){
            int i=numbers[i1];
            int j=numbers[j1];
            if(i+j<target){
                j1++;
            }else if (i+j==target){
                answer[0]=i1+1;
                answer[1]=j1+1;
                break;
            }else{
                i1++;
            }
        }*/
        Hashtable<Integer,Integer> table=new Hashtable<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(table.containsKey(numbers[i])){
                answer[0]=table.get(numbers[i])+1;
                answer[1]=i+1;
            }else {
                table.put(target - numbers[i], i);
            }
        }
        return answer;
    }
    public static double findMedianSortedArrays(int A[], int B[]) {
        double answer=0;
        int alength=A.length/2;
        int blength=B.length/2;
        double med= (double)(A.length+B.length+1)/2;
        if(A.length==0){//base case  only one array
            if(B.length%2==0){
                return (double)(B[blength]+B[blength-1])/2;
            }else{
                return (double)B[blength];
            }
        }else if (B.length==0){
            if(A.length%2==0){
                return (double)(A[alength]+A[alength-1])/2;
            }else{
                return (double)A[alength];
            }
        }else{
            int abegin=alength;
            int bbegin=blength;
            int aend=A.length-1;
            int bend=B.length-1;
            double count=alength+blength;
            if(med-count<1.6)
            if(A[alength]<B[blength]){

            }else if(A[alength]==B[blength]){

            }else{

            }
        }
        return answer;
    }
    public static double recMedianSortedArrays(int A[], int B[],int abegin,int aend,int bbegin,int bend) {
        double answer=0;
        return answer;
    }

    public static int maximumGap(int[] num) {
        class bucket{
            int max;
            int min;
            public bucket(int max,int min){
                this.max=max;
                this.min=min;
            }
        }
        int length=num.length;
        if(length<2){
            return 0;
        }
        else{
            int min=num[0];
            int max=num[0];
            for(int i=1;i<length;i++){
                if(num[i]>max) {
                    max = num[i];
                }
                if(num[i]<min){
                    min=num[i];
                }
            }
            int distance=(max-min+1)/length+1;
            bucket[] count=new bucket[length];
            for(int i=0;i<length;i++){
                int buckets=(num[i]-min)/distance;
                if(count[buckets]==null){
                    count[buckets]=new bucket(num[i],num[i]);
                }else {
                    count[buckets].max = (count[buckets].max > num[i]) ? count[buckets].max : num[i];
                    count[buckets].min = (count[buckets].min < num[i]) ? count[buckets].min : num[i];
                }
            }
            int maxgap=0;
            int last_max=count[0].max;
            for(int i=1;i<count.length;i++){
                if(count[i]==null) continue;
                int diff=count[i].min-last_max;
                maxgap=(maxgap>diff)?maxgap:diff;
                last_max=count[i].max;
            }
            return maxgap;
        }
    }
    public static void main(String [] args)    {
       // int singletest[]={2,2,3,6,6,5,5,7,7};
        //int firstMissingPositivetest[]={1};
        int[] a={1,1,1,1};
        System.out.println(maximumGap(a));
       //rotate(a,1);
      // System.out.println(hammingWeight(11));
    }
}
