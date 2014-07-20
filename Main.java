import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{

   public static void main(String [] args) throws IOException  //test find duplicate  try bubble sortu06
   {
	   int [] inputnotsort={1,3,3,5,7,9,9,13};//

	   int[]count=countingsort.countingsort(inputnotsort);
	   System.out.println("sort array:");
	   for(int i=0;i<count.length;i++){
		   int x=count[i];
		   System.out.print(x+" ");
	   }
	   System.out.println();
	   
	   int[]dup=countingsort.findduplicate(inputnotsort);
	   for(int i=0;i<dup.length;i++){
		   System.out.println("DUP"+dup[i]);
	   }
	//   System.out.println(dup);
   }

}