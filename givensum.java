import java.util.HashMap;

/**
 * Created by eagle on 2014/11/12.
 */
public class givensum {
    /**
     * find continuous series that sum = given number  . e.g.,  8+9+10 =27  13+14=27
     */
    public static HashMap<Integer,Integer> continuosseriesum(long given){
        HashMap <Integer,Integer> result=new HashMap<Integer, Integer>();
        int ini=1;
        int end=1;
        long sum=0;
        while(ini<given/2+1){
            while(sum<given){
                sum+=end++;
            }
            if(sum==given){
                result.put(ini,end-1);
            }
            sum-=ini++;
        }
        return result;
    }
    /**
     * find continuous series that product = given number  . e.g., 5*6*7=210 14*15=210
     */
    public static HashMap<Integer,Integer> continuosseriemul(long given){
        HashMap <Integer,Integer> result=new HashMap<Integer, Integer>();
        int ini=1;
        int end=1;
        long product=1;
        while(ini<given/2+1){
            while(product<given){
                product*=end++;
            }
            if(product==given){
                result.put(ini,end-1);
            }
            product/=ini++;
        }
        return result;
    }
    /**
     * find continuous elements in array that sum = given number
     */
    public static HashMap<Integer,Integer> continuosarraysum(int[] inputsortedarray,long given){
        HashMap <Integer,Integer> result=new HashMap<Integer, Integer>();
        int ini=0;
        int end=0;
        int mediumindex=findsmallthangivenindex(inputsortedarray,0,inputsortedarray.length,given/2+1);
        long sum=0;
        //find ini stop point
        while(ini<mediumindex){
            while(sum<given&&end<inputsortedarray.length){
                sum+=inputsortedarray[end++];
                //System.out.println(sum+"-"+end+"/"+given);
            }
            if(sum==given){
                result.put(ini,end-1);
            }
            sum-=inputsortedarray[ini++];
        }
        return result;
    }

    /**
     * find element of array that >=  given number  e.g., {1,2,4,5}  >3 => index2
     */
    public static int findsmallthangivenindex(int[] inputsortedarray,int iniindex,int endindex,long given){
        if(iniindex==endindex){
            return iniindex;
        }else if(inputsortedarray[(iniindex+endindex)/2]<given){
            return findsmallthangivenindex(inputsortedarray,(iniindex+endindex)/2+1,endindex,given);
        }else if(inputsortedarray[(iniindex+endindex)/2]==given){
            return (iniindex+endindex)/2;
        }else{
            return findsmallthangivenindex(inputsortedarray,iniindex,(iniindex+endindex)/2,given);
        }
    }
    public static void main(String [] args)    {
        int [] array={1,2,4,5};
       // HashMap <Integer,Integer> result=continuosarraysum(array,9);
        HashMap <Integer,Integer> result=continuosseriemul(210);
        for(int key:result.keySet()){
            System.out.println(key+"-"+result.get(key));
        }

        System.out.println(findsmallthangivenindex(array,0,4,4));
    }
}
