import java.util.Arrays;
import java.util.Stack;

/**
 * Created by eagle on 2015/6/18.
 */
public class MinStack {
    /* hardcore stack version
    static int initial_space=10;
    int [] stack= new int [initial_space];
    int stack_capacity=initial_space;
    int stack_index=0;
    int [] min_stack= new int [initial_space];
    int min_stack_capacity=initial_space;
    int min_stack_index=0;

    public void push(int x) {
        if(stack_index+1==stack_capacity){ //reach stack capacity, grow
            stack=Arrays.copyOf(stack,stack_capacity+=initial_space);
        }
        stack[stack_index++]=x;
        if(min_stack_index==0||min_stack[min_stack_index-1]>=x){
            if(min_stack_index+1==min_stack_capacity){ //reach stack capacity, grow
                min_stack=Arrays.copyOf(min_stack,min_stack_capacity+=initial_space);
            }
            min_stack[min_stack_index++]=x;
        }
    }

    public void pop() {
        if(stack[stack_index-1]==min_stack[min_stack_index-1]){
            min_stack_index--;
        }
        stack_index--;
    }
    public int top() {
        return stack[stack_index-1];
    }
    public int getMin() {
        return min_stack[min_stack_index-1];
    }*/


    Stack<Integer> Stack= new Stack<Integer>();
    Stack<Integer> MinStack= new Stack<Integer>();
    public void push(int x) {
        Stack.push(x);
        if(MinStack.isEmpty()||MinStack.peek()>=x){
            MinStack.push(x);
        }
    }

    public void pop() {
        if(!Stack.isEmpty()) {
            int x=Stack.pop();
            if(x==MinStack.peek()){
                MinStack.pop();
            }
        }
    }

    public int top() {
        return Stack.peek();
    }

    public int getMin() {
        return MinStack.peek();
    }


    public static void main(String [] args) {
        MinStack a =new MinStack();
        a.push(2147483646);
        a.push(2147483646);
        a.push(2147483647);
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        a.push(2147483647);
        System.out.println(a.getMin());
        a.push(-2147483648);
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        // int singletest[]={2,2,3,6,6,5,5,7,7};
        //int firstMissingPositivetest[]={1};
//        int[] a={};
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(-Integer.MAX_VALUE);
        //rotate(a,1);
        // System.out.println(hammingWeight(11));
    }

}
