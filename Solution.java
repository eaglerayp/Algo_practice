

import java.util.*;

/**
 * Created by Eagle on 2015/2/16.
 */
public class Solution {
    public static int singleNumber(int[] A) { //find the only single number in a array (others appear twice in the array)
        int result = 0;
        for (int i : A) result ^= i ;
        return result ;
    }
    public static int firstMissingPositive(int[] A) {// given continuous int , find first missing positive integer
        int max=0;
        int min=Integer.MAX_VALUE;
        int answer=-99;
        if(A.length==0){
            answer=1;
        }
        else {
            for(int i:A){
                if(i>0) {
                    if (i > max)
                        max = i;
                    if (i < min)
                        min = i;
                }
            }
            boolean[] counting=new boolean[max+2];
            for(int i:A){
                if(i>0) {
                    counting[i] = true;
                }
            }
            for(int i=1;i<=max+2;i++){
                if(!counting[i]) {
                    answer=i;
                    break;
                }

            }
        }
        return answer;
    }
    private static long log(long x, int base)
    {
        return (long)(Math.log(x)/Math.log(base)+1e-10);
    }
    private static long[] bitsofint(long n){
        int length=(n==0)?1:(int) Math.floor(log(n,2))+1;
        long [] answer = new long [32];
        long two_product=(long)Math.pow(2,length-1);
        for(int i=length-1;i>=0;i--){
            answer[i]= n/two_product;
            n=(answer[i]==1)?n^two_product:n;
            two_product>>>=1;
        }
        return answer;
    }
    private static long intofbits(long[] n){
        int length= n.length;
        long answer=0;
        long two_product=1;
        for(int a=0;a<length;a++){
            answer+=(n[a]==1)?two_product:0;
            two_product<<=1;
        }
        return answer;
    }
    public static long reverseBits(long n) { //given integer, return integer that its Bits are reversed from the integer
        long[]a=bitsofint(n);
        int length=a.length;
        long[]b=new long [32];
        length--;
        for(int i=0;i<=length;i++){
            b[length-i]=a[i];
        }
        long answer=intofbits(b);
        return answer;
    }
    public static void rotatebigon(int[] nums, int k) {//rotation array k steps by new array
        int length =nums.length;
        int[] answer=new int [length];
        int count=0;
        while(count<length){
            int index=(count+k)%length;
            answer[index]=nums[count];
            count++;
        }
        for(int i=0;i<length;i++){
            nums[i]=answer[i];
        }
    }
    public static void rotate(int[] nums, int k) {//rotation array k steps by swap
        int length=nums.length;
        if(length>0) {
            k %= nums.length;
            strReverse(nums,0,length-k);
            strReverse(nums,length-k,length);
            strReverse(nums,0,length);
        }
    }
    public static void strReverse(int nums[], int bgn, int end) {
        int lst = end-1;
        while(bgn<lst) {
            int tmp = nums[bgn];
            nums[bgn] = nums[lst];
            nums[lst] = tmp;
            bgn++;
            lst--;
        }
    }

    public static int hammingWeight(long n) {
       /* long[] bits=bitsofint(n);
        int answer=0;
        for(long z:bits){
            answer+=(z==1)?1:0;
        }
        return answer;*/
        int answer=0;
        /*for(int i=0;i<32;i++){
            answer+=((n&0x01)==1)?1:0;
            n>>>=1;
        }*/
        for (answer = 0; n != 0; n &= n - 1, answer++)
            ;
        return answer;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        /* sorted array version
        int i1=0;
        int j1=1;
        while(i1<numbers.length&&j1<numbers.length){
            int i=numbers[i1];
            int j=numbers[j1];
            if(i+j<target){
                j1++;
            }else if (i+j==target){
                answer[0]=i1+1;
                answer[1]=j1+1;
                break;
            }else{
                i1++;
            }
        }*/
        Hashtable<Integer,Integer> table=new Hashtable<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(table.containsKey(numbers[i])){
                answer[0]=table.get(numbers[i])+1;
                answer[1]=i+1;
            }else {
                table.put(target - numbers[i], i);
            }
        }
        return answer;
    }
    public static double findMedianSortedArrays(int A[], int B[]) {
        double answer=0;
        int alength=A.length/2;
        int blength=B.length/2;
        double med= (double)(A.length+B.length+1)/2;
        if(A.length==0){//base case  only one array
            if(B.length%2==0){
                return (double)(B[blength]+B[blength-1])/2;
            }else{
                return (double)B[blength];
            }
        }else if (B.length==0){
            if(A.length%2==0){
                return (double)(A[alength]+A[alength-1])/2;
            }else{
                return (double)A[alength];
            }
        }else{
            int abegin=alength;
            int bbegin=blength;
            int aend=A.length-1;
            int bend=B.length-1;
            double count=alength+blength;
            if(med-count<1.6)
            if(A[alength]<B[blength]){

            }else if(A[alength]==B[blength]){

            }else{

            }
        }
        return answer;
    }
    public static double recMedianSortedArrays(int A[], int B[],int abegin,int aend,int bbegin,int bend) {
        double answer=0;
        return answer;
    }

    public static int maximumGap(int[] num) {
        class bucket{
            int max;
            int min;
            public bucket(int max,int min){
                this.max=max;
                this.min=min;
            }
        }
        int length=num.length;
        if(length<2){
            return 0;
        }
        else{
            int min=num[0];
            int max=num[0];
            for(int i=1;i<length;i++){
                if(num[i]>max) {
                    max = num[i];
                }
                if(num[i]<min){
                    min=num[i];
                }
            }
            int distance=(max-min+1)/length+1;
            bucket[] count=new bucket[length];
            for(int i=0;i<length;i++){
                int buckets=(num[i]-min)/distance;
                if(count[buckets]==null){
                    count[buckets]=new bucket(num[i],num[i]);
                }else {
                    count[buckets].max = (count[buckets].max > num[i]) ? count[buckets].max : num[i];
                    count[buckets].min = (count[buckets].min < num[i]) ? count[buckets].min : num[i];
                }
            }
            int maxgap=0;
            int last_max=count[0].max;
            for(int i=1;i<count.length;i++){
                if(count[i]==null) continue;
                int diff=count[i].min-last_max;
                maxgap=(maxgap>diff)?maxgap:diff;
                last_max=count[i].max;
            }
            return maxgap;
        }
    }
     public static class ListNode {
         int val;
         ListNode next;

         public ListNode(int x) {
             val = x;
             next = null;
         }
     }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }else {
            int Alength=0;
            int Blength=0;
            ListNode Atemp=headA;
            ListNode Btemp=headB;
            while(Atemp!=null){
                Atemp=Atemp.next;
                Alength++;
            }
            while(Btemp!=null){
                Btemp=Btemp.next;
                Blength++;
            }
            int diff=Alength-Blength;
            Atemp=headA;
            Btemp=headB;
            if(diff>0){
                while(diff>0){
                    Atemp=Atemp.next;
                    diff--;
                }
            }else if(diff<0){
                while(diff<0){
                    Btemp=Btemp.next;
                    diff++;
                }
            }
            while(Atemp!=null&&Atemp.val!=Btemp.val){
                Atemp=Atemp.next;
                Btemp=Btemp.next;
            }
            return Atemp;
        }
    }

     /* Solution 1  reverse order
         if(headA!=null&&headB!=null) {
            reverseList(headA);
            reverseList(headB);
            ListNode lastsame = null;
            ListNode Atemp = headA;
            ListNode Btemp = headB;
            while (Atemp!=null&&Btemp!=null&&Atemp.val == Btemp.val) {
                lastsame = Atemp;
                Atemp = Atemp.next;
                Btemp = Btemp.next;
            }
            reverseList(headA);
            reverseList(headB);
            return lastsame;
        }else{
            return null;
        }
    }
    public void reverseList(ListNode head){
        ListNode cur=(head!=null)?head.next:null;
        ListNode prev=head;
        ListNode next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
    }*/
    //iterative version
     public ListNode reverseList(ListNode head){
         ListNode prev=null;
         if(head!=null) {
             ListNode cur= head.next;
             prev = head;
             prev.next = null;
             ListNode next;
             while (cur != null) {
                 next = cur.next;
                 cur.next = prev;
                 prev = cur;
                 cur = next;
             }
         }
         return prev;
     }
    //recursive version easy
    /*public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if(head == null){
            return prev;
        }else{
            ListNode next= head.next;
            head.next = prev;
            return reverseList(next, head);
        }
    }*/
    //recursive version hard
    /*public ListNode reverseList(ListNode head){
        if(head==null) return head;
        ListNode rest = head.next;
        if(rest==null) return head;
        rest = reverseList(rest);
        head.next.next = head;    //  Here is the trick
        head.next =null;          //
        return rest;
    }*/
    public static int trailingZeroes(int n) {
        int result=0;
        while(n!=0){
            result+=n/5;
            n/=5;
        }
        return result;
    }
    /*
    public int trailingZeroes(int n) {
        if(n<5)
            return 0;

        int x =5;
        int zero =0;
        while(x <= n/5){   // prevent x overflow , let n /5 make sure x not overflow
            zero += n/x;
            x = x*5;
        }
        zero += n/x;
        return zero;
    }*/
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public int max=Integer.MIN_VALUE;
    public int DFSmaxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left=DFSmaxPathSum(root.left);
            int right=DFSmaxPathSum(root.right);
            left=(left<0)?0:left;
            right=(right<0)?0:right;
            // check the subtree solution when DFS!!!!!  using global valuable
            int sum=left+right+root.val;
            max=(sum>max)?sum:max;

            int dfs=(left>right)?left:right;
            return dfs+root.val;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null)return true;
        int leftheight=maxDepth(root.left);
        int rightheight=maxDepth(root.right);
        boolean selfbalance=Math.abs(leftheight-rightheight)<2;
        return selfbalance&&isBalanced(root.left)&&isBalanced(root.right);
    }

     public int maxPathSum(TreeNode root) {
         DFSmaxPathSum(root);
         return max;

         /*  first version solution
        if(root==null){
            return 0;
        }else {
            int leftmax=maxPathSum(root.left);
            int rightmax=maxPathSum(root.right);
            int right=DFSTreePathSum(root.right);
            int left=DFSTreePathSum(root.left);
            int sum=right+left+root.val;
            if(leftmax>rightmax){
                if(leftmax>sum){
                    return leftmax;
                }else{
                    return sum;
                }
            }else{
                if(rightmax>sum){
                    return rightmax;
                }else{
                    return sum;
                }
            }
        }*/
     }
    public int DFSTreePathSum(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            int left=DFSTreePathSum(root.left);
            int right=DFSTreePathSum(root.right);
            int max_subtree=(left>right)?left:right;
            return max_subtree+root.val;
        }
    }
    public void reorderList(ListNode head) {
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        int swap_count=(length-1)/2;
        if(swap_count>0) {
            ListNode[] prev = new ListNode[swap_count];
            ListNode[] from = new ListNode[swap_count];
            cur = head;
            int count = 0;
            while (count < swap_count) {
                prev[count] = cur;
                cur = cur.next;
                count++;
            }
            int from_start = length - swap_count;
            while (count < from_start - 1) {
                cur = cur.next;
                count++;
            }
            //  slip the link
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            count = swap_count - 1;
            while (count >= 0) {
                from[count] = cur;
                cur = cur.next;
                count--;
            }
            for (int i = 0; i < swap_count; i++) {
                reorderInsert(prev[i], from[i]);
            }
        }
    }
    public void reorderInsert(ListNode prev,ListNode next) {
        next.next=prev.next;
        prev.next=next;
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            int height=(left>right)?left:right;
            return height+1;
        }

    }
    public HashMap<Integer,Integer> adding=new HashMap<Integer, Integer>();
    public int majorityElement(int[] num) {
        //moore voting algorithm
        int now=0;
        int count=0;
        for(int i:num){
            if(count==0){
                now=i;
                count++;
            }else{
                if(now==i){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return now;

       /*   first accepted solution
       int threshold=num.length/2;
        if(threshold==0){
            return num[0];
        }
        for(int i:num){
            if(adding.keySet().contains(i)){
                int fre=adding.get(i);
                if(fre+1>threshold) return i;
                adding.put(i,fre+1);
            }else{
                adding.put(i,1);
            }
        }
        return 0;*/
    }
    public boolean hasPath;
    public boolean hasPathSum(TreeNode root, int sum) {
        hasPath=false;
        if(root!=null)Rec_hasPathSum(root,sum);
        return hasPath;
    }
    public void Rec_hasPathSum(TreeNode root, int sum) {
        if(root.left==null&&root.right==null&&root.val==sum){// if leaf, and add to leaf =sum
            hasPath|=true;
        }else{
            if (root.left!=null){
                Rec_hasPathSum(root.left,sum-root.val);
            }
            if(root.right!=null){
                Rec_hasPathSum(root.right,sum-root.val);
            }
        }
    }
    public int removeDuplicates(int[] A) {
        int count=0;
        int prev=99999;
        for(int a:A){
            if(a!=prev){
                A[count++]=a;
                prev=a;
            }
        }
        return count;
    }
    public int removeElement(int[] nums, int val) {
        int nowindex=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[++nowindex]=nums[i];
            }
        }
        return nowindex+1;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            if(p.val==q.val){
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }else if(p==null&&q==null){
            return true;
        }else{
            return false;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastN=head;
        ListNode lastNprev=head;
        ListNode temp=head;
        for(int i=1;i<n;i++){//first move point n-1 step
            temp=temp.next;
        }
        while(temp.next!=null){
            lastNprev=lastN;
            lastN=lastN.next;
            temp=temp.next;
        }
        if(lastN==head){
            return lastN.next;
        }
        else{
            lastNprev.next=lastN.next;
            return head;
        }
    }
    public static String convert(String s, int numRows) {
        String []row=new String[numRows];
        for(int i=0;i<numRows;i++){
            row[i]="";
        }
        char[] chars = s.toCharArray();
        int sindex=0;
        while(sindex<chars.length){  //s not end
            int index=0;
            while(index<numRows&&sindex<chars.length){
                row[index++]+=chars[sindex++];
            }
            index=index-2;
            while(index>0&&sindex<chars.length){
                row[index--]+=chars[sindex++];
            }
        }
        String result="";
        for(String line:row){
            result+=line;
        }
        return result;
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    public static class Point {
            int x;
            int y;
            Point() { x = 0; y = 0; }
            Point(int a, int b) { x = a; y = b; }
     }
    public static int maxPoints(Point[] points) {
        if(points.length<3){
            return points.length;
        }
        int max=0;
        for(int a=0;a<points.length-2;a++){
            boolean [] check=new boolean[points.length];
            for(int b=0;b<points.length;b++){
                check[b]=false;
            }

            for(int b=a+1;b<points.length;b++){
                if(check[b])continue;
                while(b<points.length&&samePoints(points[a],points[b])){
                    b++;
                }
                int count = (b==points.length)?1:2;//means all points the same and count the same ,note that b is lastindex+1 ,
                // others, one line have two points
                //count same points with a
                for(int c=a+1;c<b;c++){
                    if(samePoints(points[a],points[c])){
                        count++;
                    }
                }
                for(int c=b+1;c<points.length;c++){
                    if(inALine(points[a],points[b],points[c])){
                        count++;
                        check[c]=true;
                    }
                }
                if(count>max){
                    max=count;
                }
            }
        }
        return max;
    }
    public static boolean samePoints(Point a,Point b){
        return(a.x==b.x&&a.y==b.y);
    }
    public static boolean inALine(Point a,Point b,Point c){
        return ((a.y-b.y)*(a.x-c.x)==(a.y-c.y)*(a.x-b.x));
    }
    public static String shortestPalindrome(String s) {
        // O(n^2)
       /* if(s.length()<2) return s;
        String result=s;
        int index=0;
        while(!isPalindrome(result)){
     //       System.out.println("index:"+index+"as:"+s.substring(s.length()-1-index));
            result=reverseString(s.substring(s.length()-1-index))+s;
      //      System.out.println(result);
            index++;
        }
        return result;*/

        //using KMP  ,  faster!! O(n)
        String rev_s= new StringBuilder(s).reverse().toString();
        String KMP_compare_String=s+","+rev_s;
        // compare rev_s how long same with prefix of s , so we don't have to copy this part
        int [] KMPtable=new int [KMP_compare_String.length()];// all zero
        //KMP table
        for(int i=1;i<KMPtable.length;i++){
            int temp=KMPtable[i-1];
            while(temp>0&&KMP_compare_String.charAt(i)!=KMP_compare_String.charAt(temp)){
                temp=KMPtable[temp-1];
            }
            if(KMP_compare_String.charAt(i)==KMP_compare_String.charAt(temp)){
                temp++;
            }
            KMPtable[i]=temp;
        }
        //copy without same prefix
        return rev_s.substring(0, s.length() - KMPtable[KMP_compare_String.length() - 1]) + s;
    }
    public static String reverseString(String s){
     /*   int len=s.length();
        char [] reverse=new char[len];
        for(int i=0;i<len;i++){
            reverse[i]=s.charAt(len-1-i);
        }
        return new String(reverse);*/
        return new StringBuffer(s).reverse().toString();
    }
    public static boolean isPalindrome(String s){
        if(s.length()<2) return true;
     /*   int halflen=s.length()/2;
        String left=s.substring(0,halflen);
        String right=s.substring(s.length()-halflen,s.length());*/
        char [] schar=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(schar[left]!=schar[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int [] result=new int [length];
        if(length<1) return result;
        int ex_product=1;
        for(int i=0;i<length;i++){
            result[i]=ex_product;
            ex_product*=nums[i];
        }
        int post_product=1;
        for(int i=length-1;i>=0;i--){
            result[i]*=post_product;
            post_product*=nums[i];
        }
        return result;
    }
    public static boolean isPowerOfTwo(int n) {
      /* if(n<0)return false;
       int bitone=n&0x01;
        System.out.println(bitone);
       while(n>0){
           n>>>=1;
           bitone+=n&0x01;
       }
       return bitone==1;*/
        return n > 0 && (n&(n-1))==0;  //god like   , power of 2 -1  complement with power of 2
    }
    public void deleteNode(ListNode node) {
        ListNode temp=node.next;
        node.next=temp.next;
        node.val=temp.val;
    }
    public static int addDigits(int num) {
        int digitsum=99;
        while(digitsum>9) {
            digitsum=0;
            while (num > 0) {
                digitsum += (num % 10);
                num /= 10;
            }
            num=digitsum;
        }
        return digitsum;
    }

    public static void moveZeroes(int[] nums) {
        int lastindex=nums.length-1;
        int count=0;
        for(int i=0;i<lastindex-count;i++){
            /*System.out.print(i + ":");
            for(int a:nums) {
                System.out.print(a + " ");
            }
            System.out.println();*/
            if(nums[i]==0){
                for(int j=i;j<lastindex-count;j++){
                    nums[j]=nums[j+1];
                }
                nums[lastindex-count++]=0;
                i--;
            }
        }
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>exist=new HashSet<Integer>();
        for(int element:nums){
            if(exist.contains(element)) return true;
            exist.add(element);
        }
        return false;
    }
    public static boolean Test_containsDuplicate() {
        boolean result=true;
        int test1[]={0,0,0,3,12,0};
        result&=true==containsDuplicate(test1);
        int test2[]={0,1};
        result&=false==containsDuplicate(test2);
        int test3[]={};
        result&=false==containsDuplicate(test3);
        int test4[]={0,5,0,5};
        result&=true==containsDuplicate(test4);
        return result;
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while(cur!=null){
            if(cur.next!=null&&cur.next.val==cur.val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
    public static void Test_deleteDuplicates() {
        ListNode a=new ListNode(5);
        a.next=new ListNode(5);
        a.next.next=new ListNode(5);
        deleteDuplicates(a);
        while(a!=null){
            System.out.print(a.val);
            a=a.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode head=(l1.val<=l2.val)?l1:l2;
        ListNode l1prev=null;
        ListNode l2prev=null;
        while(l1!=null&&l2!=null) {
            if (l1.val <= l2.val) {
                while (l1 != null && l1.val <= l2.val) {
                    l1prev = l1;
                    l1 = l1.next;
                }
                // insert l1prev -> l2
                if(l2prev!=null)l2prev.next = l1prev;
                if(l1prev!=null)l1prev.next = l2;
                if(l1!=null)l1prev = null;// not l1 end case
                if(l2prev!=null)l2prev = l1prev;
            } else { //l2<l1 case
                while (l2 != null && l1.val > l2.val) {
                    l2prev = l2;
                    l2 = l2.next;
                }
                // insert l2prev -> l1
                if(l1prev!=null)l1prev.next = l2prev;
                if(l2prev!=null)l2prev.next = l1;
                if(l2!=null)l2prev = null;// not l1 end case
                if(l1prev!=null)l1prev = l2prev;
            }
        }
        return head;
    }
    public static void Test_mergeTwoLists() {
        /*ListNode l1_head= new ListNode(5);
        ListNode l2_head= new ListNode(1);
        ListNode next =new ListNode(2);
        l2_head.next=next;
        next.next=new ListNode(3);
        next.next.next=new ListNode(4);
        next.next.next.next=new ListNode(7);
        l1_head.next=new ListNode(6);
        ListNode head=mergeTwoLists(l2_head,l1_head);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();*/
        ListNode l3_head= new ListNode(1);
        ListNode l4_head= new ListNode(1);
        ListNode head=mergeTwoLists(l3_head,l4_head);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return Rec_isSymmetric(root.left,root.right);
        /* use invert and same
        TreeNode right= invertTree(root.right);
        boolean result=isSameTree(left,right);
        right= invertTree(root.right); //Reduction
        return result;*/

    }
    public static boolean Rec_isSymmetric(TreeNode left,TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        return Rec_isSymmetric(left.left,right.right)&&Rec_isSymmetric(left.right,right.left);
    }
    public static boolean Test_isSymmetric() {
        boolean result=true;
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(3);

        result&=isSymmetric(root);
        System.out.println(result);
        root.right.right=new TreeNode(1);
        result&=(isSymmetric(root)==false);
        System.out.println(result);
        root.left.left=new TreeNode(1);
        result&=isSymmetric(root);
        System.out.println(result);
        return result;
    }
    public static int minHeight(TreeNode root) {//BFS use queue
        if (root==null) return 0;
        int height=1;
        int index=1;
        int next_index=(int)Math.pow(2,height);
        Queue<TreeNode> BFS_queue=new ArrayDeque<TreeNode>();
        BFS_queue.offer(root);
        while(!BFS_queue.isEmpty()) {
            root=BFS_queue.poll();
            if (root.left == null && root.right == null)
                return height;
            if (root.left == null || root.right == null)
                return height;
            BFS_queue.offer(root.left);
            BFS_queue.offer(root.right);
            index++;
            if (index == next_index)
                height++;
            next_index=(int)Math.pow(2,height);
        }
        return height;
    }

    public static boolean Test_minHeight() {
        boolean result=true;
//        System.out.println(minHeight(null));
//        result&=(minHeight(null)==0);
        System.out.println(result);
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(3);
//        System.out.println(minHeight(root));
//        result&=minHeight(root)==2;
        System.out.println(result);
        root.right.right=new TreeNode(1);
//        result&=(minHeight(root)==2);
        System.out.println(result);
        root.left.left=new TreeNode(1);
        result&=minHeight(root)==2;
        System.out.println(result);
        return result;
    }
    public static int minDepth(TreeNode root) {//BFS use queue
        if (root==null) return 0;
        int height=1;
        int index=0;
        int next_index=1;
        int layernode=0;
        ArrayList<TreeNode> BFS_queue=new ArrayList<TreeNode>();
        BFS_queue.add(root);
        while(!BFS_queue.isEmpty()) {
            root=BFS_queue.get(0);
            BFS_queue.remove(0);
            if(root!=null) {
                if (root.left == null && root.right == null) //leaf
                    return height;
                if(root.left!=null)layernode++;
                if(root.right!=null)layernode++;
                BFS_queue.add(root.left);
                BFS_queue.add(root.right);
                index++;
            }

            if (index == next_index) {
                height++;
                next_index+=layernode;
                layernode=0;
            }
        }
        return height;
    }
    public static boolean Test_minDepth() {
        boolean result=true;
//        System.out.println(minDepth(null));
//        result&=(minDepth(null)==0);
        System.out.println(result);
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
       // root.right=new TreeNode(3);
//        System.out.println(minHeight(root));
//        result&=minDepth(root)==2;
        System.out.println(result);
  //      root.right.right=new TreeNode(1);
//        result&=(minDepth(root)==2);
        System.out.println(result);
        root.left.left=new TreeNode(1);
//        result&=minDepth(root)==3;
//        System.out.println(result);
        root.left.left.left=new TreeNode(1);
        result&=minDepth(root)==4;
        System.out.println(result);
        return result;
    }
    public int[] plusOne(int[] digits) {
        int index=digits.length-1;
        while(index>=0){
            if(digits[index]!=9){
                digits[index]+=1;
                return digits;
            }else{
                digits[index--]=0;
                if(index<0){
                    int [] newdigits=new int [digits.length+1];
                    newdigits[0]=1;
                    for(int i=1;i<newdigits.length;i++){
                        newdigits[i]=digits[i-1];
                    }
                    return newdigits;
                }
            }
        }
        return digits;
    }

    public boolean isPalindrome(int x) {
        if(x<0) return false;

    }
    public int reverse(int x) {
        int y=0;
        boolean negative=false;
        if(x<0) {
            negative=true;
            x*=-1;
        }
        while(x>0){
            y*=10;
            y+=(x%10);
            x/=10;
        }
        if(negative) y*=-1;

        //check overflow returns 0 when the reversed integer overflows.
        return y;
    }
    public static void main(String [] args)    {
        /*Point[] points=new Point[5];
        for(int i=0;i<5;i++){
            points[i]=new Point(1,1);
        }
        points[3]=new Point(2,1);*/
        /* test moveZeroes
        int singletest[]={0,0,0,3,12,0};
        moveZeroes(singletest);
        for(int a:singletest)
            System.out.print(a+" ");
        System.out.println();*/
      //  Test_mergeTwoLists();
        //Test_deleteDuplicates();
        System.out.println(Test_minDepth());

        /*for(long a:bitsofint(192L)){
            System.out.print(a);
        }*/
        /*System.out.println(addDigits(44));

        int [] a=new int[2];
        String s="aacc";
        int halflen=s.length()/2;
        String left=s.substring(0,halflen);
        String right=s.substring(s.length()-halflen,s.length());
        System.out.println(isPowerOfTwo(25));
        System.out.println(a[0]);*/
        /*long task_start=System.currentTimeMillis();
long task_end=System.currentTimeMillis();
        System.out.println(task_start);
        System.out.println(task_end);*/
       // int singletest[]={2,2,3,6,6,5,5,7,7};
        //int firstMissingPositivetest[]={1};

       //rotate(a,1);
        /* test hammingWeight
       System.out.println(hammingWeight(7));*/

    }
}
