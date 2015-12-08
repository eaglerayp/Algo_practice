testfunction repo introduction
============

testfunction contain my practicing project about DS and program efficiency

###basic DS and algorithm
* [counting sort] (https://github.com/eaglerayp/testfunction/blob/master/countingsort.java)
* [binary search tree] (https://github.com/eaglerayp/testfunction/blob/master/balancetree.java)
* [red-black tree(incomplete)] (https://github.com/eaglerayp/testfunction/blob/master/balancetree.java)
* [binary compute] (https://github.com/eaglerayp/testfunction/blob/master/binary_compute.java)  include getMax(a,b) , sum if n>X , isEven


###classic problem
* [plateau](https://github.com/eaglerayp/testfunction/blob/master/plateau.java)
* [dominance count(GT)](https://github.com/eaglerayp/testfunction/blob/master/GT_count.java)
* [coincidence count(EQ)](https://github.com/eaglerayp/testfunction/blob/master/EQ_count.java)
* [min distance(mindist)](https://github.com/eaglerayp/testfunction/blob/master/mindist.java)
* [equal pre/postfix sum(headtail)](https://github.com/eaglerayp/testfunction/blob/master/headtail.java)

###numeral problem
* [Armstrong number] (https://github.com/eaglerayp/testfunction/blob/master/Armstrong.java) 找出armstrong數 三位數恰好等於三個數字的三次方和
* [Primes] (https://github.com/eaglerayp/testfunction/blob/master/Prime.java)求n個質數
* [Primes-Sieve of Eratosthenes] (https://github.com/eaglerayp/testfunction/blob/master/Sieve.java)  給定數字範圍內篩出所有質數
* [Primes-Linear Sieve ] (https://github.com/eaglerayp/testfunction/blob/master/linearSieve.java) 線性篩質數 (所有數只會被篩一次)
* [factor ] (https://github.com/eaglerayp/testfunction/blob/master/factor.java) 因數分解
* [R_power ] (https://github.com/eaglerayp/testfunction/blob/master/R_power.java) m的n次方數 Divide and conquer解 
* [I_power ] (https://github.com/eaglerayp/testfunction/blob/master/I_power.java) m的n次方數 非遞迴 將n視為2進位解 
* [Fib_MT](https://github.com/eaglerayp/testfunction/blob/master/Fib_MT.java) fibonacci數列快速矩陣解
* [CNR_ADD](https://github.com/eaglerayp/testfunction/blob/master/CNR_ADD.java) array最少次加法解Cn取r的組合問題
* [CNR_LOG](https://github.com/eaglerayp/testfunction/blob/master/CNR_LOG.java) Cn取r的組合問題logn解法
* [FACTLOG2](https://github.com/eaglerayp/testfunction/blob/master/FACTLOG2.java) logn次乘法解factorial
* [FACTLOG](https://github.com/eaglerayp/testfunction/blob/master/FACTLOG.java) logn次乘法解factorial, factlog2精簡版  節省重複運算c(n)(n/2)...
* [givensum](https://github.com/eaglerayp/testfunction/blob/master/givensum.java) 找出連續數列  之和=給定數字 

###Set, Combination and Permutation problem
* [direct](https://github.com/eaglerayp/testfunction/blob/master/direct.java) 找出連續數字的所有集合

###basic Java file read uniqueid
* [readid] (https://github.com/eaglerayp/testfunction/blob/master/readid.java)

###Java regex example
* [Regex] (https://github.com/eaglerayp/testfunction/blob/master/Regex.java)

### leetcode oj solution
* [Solution] (https://github.com/eaglerayp/testfunction/blob/master/Solution.java)
   including singleNumber,firstMissingPositive,Two Sum,	Number of 1 Bits,Reverse Bits,Rotate Array,maxPathSum,maximumGap,getIntersectionNode,isBalanced
   removeElements,Same Tree, Remove Nth Node From End of List, ZigZag Conversion , Invert binary tree , maxPoints  , shortestPalindrome (with KMP) , ispowerof2,
   productExceptSelf ,removeListNodewithoutroot, addDigits, moveZeroes ,containsDuplicate,deleteDuplicates  , mergeTwoLists, isSymmetric, minDepth (not minHeight),
   plusOne, reverseInt, isPalindrome


   Using Stack:BSTIterator
   Using Queue: BFS ( minDepth,minHeight)
   reverseLinkedList: recursive version

   trailingzeroes **highligh overflow problem**

* [LRUCache] (https://github.com/eaglerayp/testfunction/blob/master/LRUCache.java)
   LRUCache problem have 1.HashMap and double linked list  and 2. linkedHashMap  two solutions. 
   
   problem can be found in https://leetcode.com/problemset/algorithms/

* [minstack] (https://github.com/eaglerayp/testfunction/blob/master/MinStack.java)
   solve minstack by using two stack  based on the property of stack : 一旦pop到min value 前面的value已經pop玩了 所以只要記住後面還沒被Pop的min value即可

* [MyQueue] (https://github.com/eaglerayp/testfunction/blob/master/MyQueue.java)
   solve MyQueue by using two stack  based on the property of stack : 利用一個popstack 和pushstack完成simulation of queue,
   修改pop()要是popstack還沒東西就把pushstack全部pop-push到popstack,這樣popsatck就是queue的order了


