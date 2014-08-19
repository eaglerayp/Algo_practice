import java.util.ArrayList;


public class linearSieve {
	public static int[] next;
	public static int[] prev;
	public static int Next(int x){
		return next[x];
	}
	public static void remove(int x){
		next[prev[x]]=next[x];
		prev[next[x]]=prev[x];
	}
    public static int[] findprimes(int N){
    	next= new int[N+1];
    	prev= new int[N+1];
    	int count=N-1;
    	//intialization
    	for (int i=0;i<N;i++){
    		next[i]=i+1;
    		prev[i]=i-1;
    	}
    	next[N-1]=0;
    	prev[2]=0;
    	for(int prime=2;prime*prime<=N;prime=Next(prime)){
    		System.out.println("PRIME"+prime+" ");
    		for(int fact=prime;fact*prime<=N;fact=Next(fact)){
    			for(int mult=fact*prime;mult<=N;mult*=prime){
    				remove(mult);
    				count--;
    			}
    		}
    	}
    	int[] res=new int[count];
    	int index=0;
    	for(int i=2;i!=0;i=Next(i)){
    		//System.out.print(i+" ");
    		res[index]=i;
    		index++;
    	}
    	return res;
    }
}
