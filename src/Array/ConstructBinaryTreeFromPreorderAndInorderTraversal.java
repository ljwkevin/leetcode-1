package Array;

import java.util.HashMap;

import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月19日
 * @Description
 * 
 * 题目描述:</br>
 * 根据先序遍历和中续遍历构造二叉树.</br>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
	}
	//int[] preorder = {1,2,4,5,3,6};
	//int[] inorder ={4,5,2,1,6,3};
	public TreeNode _buildTree(int[] preorder,int bg1,int ed1, int[] inorder,int bg2,int ed2) {
		if(ed1<bg1)
			return null;
		TreeNode node = new TreeNode(preorder[bg1]);
		if(bg1==ed1)
			return node;
		int pos2=0;
		for(int i=bg2;i<=ed2;++i)
			if(inorder[i]==preorder[bg1]){
				pos2=i;
				break;
			}
		int pos1 = pos2-bg2+bg1;
		node.left = _buildTree(preorder, bg1+1, pos1, inorder, bg2, pos2-1);		
		node.right = _buildTree(preorder, pos1+1, ed1, inorder, pos2+1, ed2);
		return node;
	}
		
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0)
			return null;
		return _buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	void printPreorder(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.val+" ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	void printPostorder(TreeNode node){
		if(node==null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val+" ");
	}
	
	
	void printInorder(TreeNode node){
		if(node==null)
			return;
		printInorder(node.left);
		System.out.print(node.val+" ");
		printInorder(node.right);
	}
	
	/**
	 *  1
	 *2   3
	 4 5 6
	 * @Title: main 
	 * void
	 */
	@Test
	public void main(){
		int[] preorder = {1,2,4,3,5};
		int[] inorder ={1,2,3,4,5};
		TreeNode node = buildTree(preorder, inorder);
		printPreorder(node);
		System.out.println();
		printInorder (node);
		System.out.println();
		printPostorder(node);
		
	}
}
