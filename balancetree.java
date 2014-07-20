
public class balancetree {
	TreeNode root;
	
	public 	void create (int[] input){
		for(int i=0;i<input.length;i++){
			this.insert(root,input[i]);
		}
	}
	private void insert (TreeNode subroot,int element){
		//insert part
		if (subroot==null){  //root case
			subroot=new TreeNode(element,false,null,null); 
		}else{
			if(subroot.data>element){ // left case
				insert(subroot.left,element);
			}else if(subroot.data<element){ //right case
				insert(subroot.right,element);
			}else{//duplicate case
				//do nothing or error
				System.out.println("duplicate element:"+element);
			}
		}
		
		//check black or red part 
	}
}
