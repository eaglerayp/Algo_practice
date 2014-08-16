import java.util.ArrayList;


public class Sieve {
	/**
     * find primes in first N numbers  
     * @param N
     * @return res   n primes in N numbers
     */
    public static int[] findprimes(int N){
        boolean []numbers=new boolean[N];
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=2;i<N;i++){ //initialization
        	numbers[i]=true;
        }
        for(int i=2;i<N;i++){
        	if(numbers[i]){//is prime
        		result.add(i);
        		for(int k=i+i;i*i<=N&&k<N;k+=i){
        			numbers[k]=false;
        		}
        	}
        }
        int []res=new int[result.size()];
        for(int i=0;i<result.size();i++){
        	res[i]=result.get(i);
        }
        result.clear();
        return res;
    }
}
