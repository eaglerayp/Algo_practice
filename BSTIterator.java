import java.util.Stack;

/**
 * Created by Eagle on 2015/8/8.
 */
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private Stack<TreeNode> stack=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode cur=root;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
       TreeNode cur=stack.pop();
        int val=cur.val;
        cur=cur.right;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        return val;
    }
}
