package Tree;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 题目参考：https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
	   
	   public TreeNode invertTree(TreeNode root) {
		    if(root!=null){
		    	TreeNode tmp = root.left;
		    	root.left = root.right;
		    	root.right = tmp;
		    	invertTree(root.left);
		    	invertTree(root.right);
		    }
	        return root;
	   }
	   
	   @Test
	   public void main(){
		    TreeNode t1 = new TreeNode(4);
			TreeNode t2 = new TreeNode(2);
			TreeNode t3 = new TreeNode(7);
			TreeNode t4 = new TreeNode(1);
			TreeNode t5 = new TreeNode(3);
			TreeNode t6 = new TreeNode(6);
			TreeNode t7 = new TreeNode(9);

			t1.left = t2;
			t1.right = t3;
			t2.left = t4;
			t2.right = t5;
			t3.left = t6;
			t3.right = t7;
			
			TreeUtil.print(t1);
			t1 = invertTree(t1);
			TreeUtil.print(t1); 
	   }
}
