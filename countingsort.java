import java.util.ArrayList;


public class countingsort {
	   public static int[] sort(int[] input){
		   int max=0;
		   int[] result=new int[input.length];
		   for(int i=0;i<input.length;i++){  //find max
			    int c = input[i] - max;//a-b
			    int k = (c >> 31) & 1;//bit: 0 or 1
			    max = input[i] - k * c; //a - 0*(a-b)=a  or a-1(a-b) = b
		   }
		   max++;
		   int[] count=new int[max];
		   for(int i=0;i<input.length;i++){  // can find duplicate element if  "count>1"
			   count[input[i]]++;
		   }
		   int total=0;
		   for(int i=0;i<max;i++){
			   int temp=count[i];
			   count[i]=total;
			   total+=temp;
		   }
		   for(int i=0;i<input.length;i++){
			   int x=input[i];
			   result[count[x]]=x;
			   count[x]++;		   
		   }
		   return result;
	   }
	   public static int[] findduplicate(int[] input){
		   int max=0;
		   ArrayList<Integer> result=new ArrayList<Integer>();
		   for(int i=0;i<input.length;i++){  //find max
			    int c = input[i] - max;//a-b
			    int k = (c >> 31) & 1;//bit: 0 or 1
			    max = input[i] - k * c; //a - 0*(a-b)=a  or a-1(a-b) = b
		   }
		   max++;
		   int[] count=new int[max];
		   for(int i=0;i<input.length;i++){
			   count[input[i]]++;
		   }
           for(int i=0;i<count.length;i++){// can find duplicate element if  "count>1"
               if(count[i]>1){
                   result.add(i);
               }
           }
		   int[]dups=new int[result.size()];
		   for(int i=0;i<result.size();i++){
			   dups[i]=result.get(i);
		   }
		   result.clear();
		   return dups;
	   }
}
