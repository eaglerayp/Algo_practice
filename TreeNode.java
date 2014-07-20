
public class TreeNode {
	public int data;
	public boolean red=false; // red or black
	public TreeNode left=null;
	public TreeNode right=null;
    public TreeNode(int n,boolean r,TreeNode ln,TreeNode rn) {
        this.data = n;
        this.red = r;
        this.left = ln;
        this.right = rn;
    }
}
