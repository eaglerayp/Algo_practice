import java.io.IOException;


public class Main
{

   public static void main(String [] args) throws IOException  //test find duplicate  try bubble sortu06
   {
	   int [] inputnotsort={1,6,3,5,7,9,8};//
	   balancetree.create(inputnotsort);
	   System.out.println(balancetree.root.data);
	   int[]count=testfunction.countingsort(inputnotsort);
	   System.out.println("sort array:");
	   for(int i=0;i<count.length;i++){
		   int x=count[i];
		   System.out.print(x+" ");
	   }
	   System.out.println();
	   
	   int[]dup=testfunction.findduplicate(inputnotsort);
	   for(int i=0;i<dup.length;i++){
		   System.out.println("DUP"+dup[i]);
	   }
	//   System.out.println(dup);
   }

}