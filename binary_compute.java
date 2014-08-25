/**
 * Created by eagle on 2014/8/23.
 */
public class binary_compute {
    public static int getMax(int a, int b) {
        int c = a - b;
        int k = (c >> 31) & 0x1;
        int max = a - k * c;
        return max;
    }

    public static int sumifbiggerthanx(int a[] , int threshold){ //avoid branch prediction
        int sum=0;
        int temp=0;
        for (int b:a){
            temp=b-threshold>>31;
            sum+=~temp&threshold;
        }
        return sum;
    }

    public static boolean isEven(int a){
        return (a&0x01)==0;
    }
}
