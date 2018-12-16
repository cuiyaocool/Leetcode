package leetcode;

import java.util.LinkedList;

import common.TreeNode;

public class _0450DelNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(4);
		TreeNode c3 = new TreeNode(7);

		TreeNode b1 = new TreeNode(3, c1, c2);
		TreeNode b2 = new TreeNode(6, null, c3);

		TreeNode root = new TreeNode(5, b1, b2);

		printTree(root);
		int key = 3;
		delNode(root, key);
	}

	private static void delNode(TreeNode root, int key) {
		// TODO Auto-generated method stub
		TreeNode delNode = findDelNode(root, key);
		if (delNode == null) {
			System.out.println("Has no node");
			return;
		}else if(delNode.left == delNode.right){
			delNode = null;
			return;
		}

		TreeNode insteadNodeInLeft = findLeft_Right(delNode.left);
		if (insteadNodeInLeft != null) {
			//System.out.println(insteadNodeInLeft.value);
			delNodeAndInsteadOfLeft(root, delNode, insteadNodeInLeft);
		} 
//		else {
//			TreeNode insteadNodeInRight = findRight_Left(delNode.right);
//			delNodeAndInsteadOfRight(root, delNode, insteadNodeInRight);
//		}
	}

//	private static void delNodeAndInsteadOfRight(TreeNode root,
//			TreeNode delNode, TreeNode insteadNodeInRight) {
//		// TODO Auto-generated method stub
//		if (root == delNode) {
//			if (insteadNodeInRight == delNode.right) {
//				insteadNodeInRight.right = delNode.right;
//			}
//		}
//		
//		
//	}

	private static void delNodeAndInsteadOfLeft(TreeNode root,
			TreeNode delNode, TreeNode insteadNodeInLeft) {
		TreeNode rNode = root, dNode = delNode, iNode = insteadNodeInLeft;
		// TODO Auto-generated method stub
		if (rNode == dNode) {
			if (insteadNodeInLeft == dNode.left) {
				insteadNodeInLeft.right = dNode.right;
				
			}
		} else {
			TreeNode parentOfDel = findParentOfDel(rNode, dNode);
			if (parentOfDel.left == dNode) {
				parentOfDel.left = iNode;
				iNode.right = delNode.right;
				printTree(root);
			}
		}
	}

	private static TreeNode findParentOfDel(TreeNode root, TreeNode delNode) {
		// TODO Auto-generated method stub
		TreeNode rNode = root, pNode = null;
		;
		while (rNode != delNode) {
			if (rNode.value < delNode.value) {
				pNode = rNode;
				rNode = rNode.right;
			}
			if (rNode.value > delNode.value) {
				pNode = rNode;
				rNode = rNode.left;
			}
		}

		return pNode;
	}

	// 找到替换被删结点的结点，在左子树的最右边
//	private static TreeNode findRight_Left(TreeNode delRightNode) {
//		// TODO Auto-generated method stub
//		if (delRightNode == null) {
//			return null;
//		}
//		TreeNode last = delRightNode, temp = delRightNode.left;
//
//		while (temp != null) {
//			last = temp;
//			temp = temp.left;
//
//		}
//		return last;
//	}

	// 找到替换别删结点的结点，在右子树的最左边。
	private static TreeNode findLeft_Right(TreeNode delLeftNode) {
		// TODO Auto-generated method stub
		if (delLeftNode == null) {
			return null;
		}
		TreeNode last = delLeftNode, temp = delLeftNode.right;

		while (temp != null) {
			last = temp;
			temp = temp.right;
		}
		return last;
	}

	/**
	 * 寻找key对应的结点。
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private static TreeNode findDelNode(TreeNode root, int key) {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		}
		if (root.value == key) {
			return root;
		}
		if (root.value < key) {
			return findDelNode(root.right, key);
		} else {
			return findDelNode(root.left, key);
		}
	}

	/**
	 * 层次打印出树，包括null
	 * 
	 * @param root
	 */
	private static void printTree(TreeNode root) {
		// TODO Auto-generated method stub
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		}
		list.add(root);
		while (!list.isEmpty()) {
			TreeNode node = list.remove();
			if (node == null) {
				System.out.print("null ");
			} else {
				System.out.print(node.value + " ");
				list.add(node.left);
				list.add(node.right);
			}

		}
		System.out.println();
	}
}
