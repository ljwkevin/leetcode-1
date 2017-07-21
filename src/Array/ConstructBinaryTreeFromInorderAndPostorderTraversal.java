package Array;

import org.junit.Test;

import Array.ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode;

/**
 * @author 闵大为
 * @date 2015年7月19日
 * @Description
 *
 * 题目描述:</br>
 * 根据中序遍历和后续遍历构造二叉树.</br>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode _buildTree(int[] inorder,int bg1,int ed1, int[] postorder,int bg2,int ed2) {
		if(ed2<bg2)
			return null;
		TreeNode node = new TreeNode(postorder[ed2]);
		if(bg2==ed2)
			return node;
		int pos1=0;
		for(int i=bg1;i<=ed1;++i)
			if(inorder[i]==postorder[ed2]){
				pos1=i;
				break;
			}
		int pos2 = pos1-bg1+bg2-1;
		node.left = _buildTree(inorder, bg1, pos1-1, postorder, bg2, pos2);		
		node.right = _buildTree(inorder, pos1+1, ed1, postorder, pos2+1, ed2-1);
		return node;
	}
		
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0)
			return null;
		return _buildTree(inorder, 0,inorder.length-1, postorder, 0, postorder.length-1);
	}

	void printPreorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		printPreorder(node.left);
		
		printPreorder(node.right);
	}

	void printPostorder(TreeNode node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	void printInorder(TreeNode node) {
		if (node == null)
			return;
		
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	/**
	 * 1
	 *2   3
	 4 5 6
	 * 
	 * @Title: main void
	 */
	@Test
	public void main() {
		// pre 1 2 4 3 5 
		int[] inorder = { 1, 2, 3, 4, 5 };
		int[] postorder = {3, 5, 4, 2, 1};
	// 1 2 4 5 3 6
	//	int[] inorder =   {4,2,5,1,6,3};
	//	int[] postorder = {4,5,2,6,3,1};

		TreeNode node = buildTree(inorder,postorder);
		printPreorder(node);
		System.out.println();
		printInorder(node);
		System.out.println();
		printPostorder(node);

	}
}
