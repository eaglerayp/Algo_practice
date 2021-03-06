import java.io.IOException;
import java.util.*;


public class Main
{
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
   public static void main(String [] args) throws IOException  //test find duplicate  try bubble sortu06
   {
       List<Integer> ab =new ArrayList<>();
       ab.add(0,2);
       ab.add(1,4);
       System.out.println(ab.size());
       String OTP="";
       Random r=new Random(new java.util.Date().getTime());
       for(int i=1;i<=6;i++){
           int a = r.nextInt(35)+1;
           if(a<9){
               String b = Integer.toString(a);
               OTP= OTP + b;
           }
           else  {
               a=a+87;
               String c = String.valueOf((char)a);
               OTP = OTP+c;
           }
       }
       System.out.println("OTP:"+OTP);
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
       double startTime,endTime,totTime;
       startTime = System.currentTimeMillis();
       int []primes=Sieve.findprimes(120);
       totTime = System.currentTimeMillis()-startTime;
       System.out.print("Sieve:"+totTime);
       startTime = System.currentTimeMillis();
       int []lprimes=linearSieve.findprimes(120);
       totTime = System.currentTimeMillis()-startTime;
       System.out.print("LSieve:"+totTime);
       System.out.print("Prime value < N(120):");
       for (int i:primes){
           System.out.print(" "+i);
       }
       System.out.println();
       System.out.print("Linear Prime value < N(120):");
       for (int i:lprimes){
           System.out.print(" "+i);
       }
       System.out.println();

       HashMap<Integer,Integer> facs=factor.factors(2150);
       System.out.print("factors:"+99+"=");
       for(int key:facs.keySet()){
           System.out.print(key+"^"+facs.get(key)+" * ");
       }
       System.out.println();
       long power= R_power.power(2,9);
       long Ipower= I_power.power(2,9);
       System.out.println("2^9:"+power);
       System.out.println("2^9 Ipower:"+Ipower);
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