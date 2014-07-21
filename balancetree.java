
public class balancetree {
	static TreeNode root;
	
	public static void create (int[] input){
		for(int i=0;i<input.length;i++){
			root=insert(root,input[i]);
		}
		traverse();
	}
	private static TreeNode insert(TreeNode subroot,int element){
		//insert part
		if (subroot==null){  //root case
			subroot=new TreeNode(element,false,null,null); 
			return subroot;
		}else{
			if(subroot.data>element){ // left case
				subroot.left=insert(subroot.left,element);
			}else if(subroot.data<element){ //right case
				subroot.right=insert(subroot.right,element);
			}else{//duplicate case
				//do nothing or error
				System.out.println("duplicate element:"+element);
				return null;
			}
			//check black or red part 
			
			
			return subroot;
		}
		
		
	}
	
	public static void traverse(){
		printnode(root);
	}
	private static void printnode(TreeNode node){
		if(node!=null){
			if(node.left!=null){
				printnode(node.left);
			}
			System.out.println(node.data);
			if(node.right!=null){
				printnode(node.right);
			}
		}
	}
}
