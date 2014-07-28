import java.io.IOException;


public class Main
{

   public static void main(String [] args) throws IOException  //test find duplicate  try bubble sortu06
   {
	   int [] inputsortsame ={1,2,2,3,3,3,3,3,3,4,5,5,6};  //example input
	   int [] inputnotsort={1,6,3,5,7,9,8};//
	   balancetree.create(inputnotsort);
	   System.out.println("now ROOT:"+balancetree.root.data);
	   int[]count=countingsort.countingsort(inputnotsort);
	   System.out.print("counting-sort array:");
	   for(int i=0;i<count.length;i++){
		   int x=count[i];
		   System.out.print(x+" ");
	   }
	   System.out.println();
	   
	   int[]dup=countingsort.findduplicate(inputsortsame);
       System.out.print("Duplicate element:");
	   for(int i=0;i<dup.length;i++){
		   System.out.print(dup[i]+" ");
	   }
       System.out.println();
	   int longestlength=plateau.findlongestlength(inputsortsame);
       int longestelement=plateau.findlongestelement(inputsortsame);
	   System.out.println("sortsamearray's longest plateau:"+longestlength);
       System.out.println("sortsamearray's longest element:"+longestelement);
   }

}