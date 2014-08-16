import java.io.IOException;


public class Main
{

   public static void main(String [] args) throws IOException  //test find duplicate  try bubble sortu06
   {
	   int [] inputsortsame ={1,2,2,3,3,3,3,3,3,4,5,5,6};  //example input
	   int [] inputnotsort={1,6,3,5,7,9,8};//
       int [] f= {1,3,5,7,9};
       int [] g={2,3,4,7,8};
       int [] y={3,6,2,1,4,5,2};//example input of headtail
       int [] z={-10,13};
       int gt= GT_count.findGTcount(f,g);
       System.out.println("GT of f,g:"+gt);
       int EQ= EQ_count.findEQcount(f,g);
       System.out.println("EQ of f,g:"+EQ);
       int minidist= mindist.findmindistance(f,z);
       System.out.println("min distance of f,z:"+minidist);
       int headtailEQ= headtail.findEQheadtail(y);
       System.out.println("count of equal pre/postfix sum of y:"+headtailEQ);
       int []armstrong=Armstrong.findallarms();
       System.out.print("Armstrong value:");
       for (int i:armstrong){
           System.out.print(" "+i);
       }
       System.out.println();
       int []Nprimes=Prime.findNprimes(20);
       System.out.print("first N(20) Prime value:");
       for (int i:Nprimes){
           System.out.print(" "+i);
       }
       System.out.println();
       
       int []primes=sieve.findprimes(120);
       System.out.print("Prime value < N(120):");
       for (int i:primes){
           System.out.print(" "+i);
       }
       System.out.println();
	   /*balancetree.create(inputnotsort);
	   System.out.println("now ROOT:"+balancetree.root.data);*/
	   int[]count=countingsort.sort(inputnotsort);
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