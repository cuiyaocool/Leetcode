package common;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(){
		
	}
	
	public TreeNode(int value) {
		this.value = value;
		left = right = null;
	}
}
