import java.util.ArrayList;

/**
 * Created by syshih on 2014/8/13.
 */
public class Armstrong {
    public static boolean check3digits(int x){
        if(x/1000<=0&&x/100>0){
            return true;
        }else{
            return false;
        }
    }
    public static int[] findallarms(){
        int a=1;
        int b=0;
        int c=0;
        int sum= 0;
        int num=0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        for (c=0;c<=9;c++){
            for(b=0;b<=9;b++){
                for(a=1;a<=9;a++){
                    sum=a*a*a+b*b*b+c*c*c;
                    num=100*a+10*b+c;
                    if(sum==num){
                        result.add(sum);
                    }
                }
            }
        }
        int []res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public static int[] findallarms1(){
        int a=1;
        int b=0;
        int c=0;
        int sum= 0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        for (int i=100;i<1000;i++){
            a=i/100;
            b=i%100/10;
            c=i%10;
            sum=a*a*a+b*b*b+c*c*c;
            if(sum==i){
                result.add(sum);
            }
        }
        int []res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
}
