import java.util.Stack;

/**
 * Created by ray on 2015/9/25.
 */
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> pushstack=new Stack<Integer>();
    Stack<Integer> popstack=new Stack<Integer>();
    public void push(int x) {
        pushstack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        popstack.pop();
    }

    // Get the front element.
    public int peek() {
        if(popstack.empty()){
            while(!pushstack.empty()){
                popstack.push(pushstack.pop());
            }
        }
        return popstack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushstack.empty()&&popstack.empty();
    }
    public static void main(String [] args)    {
        MyQueue a= new MyQueue();
        a.push(5);
        System.out.println(a.peek());
        a.push(4);
        a.pop();
        a.push(3);
        System.out.println(a.peek());
        a.pop();
        a.push(2);
        System.out.println(a.empty());
        System.out.println(a.peek());
    }
}