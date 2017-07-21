package Tree;

/**
 * @author 闵大为
 * @date 2015年8月2日
 * @Description
 * 题目参考：https://leetcode.com/problems/balanced-binary-tree/ <br/>
 * 解题参考：https://leetcode.com/discuss/49573/a-clean-and-fast-dfs-approach
 */

public class BalancedBinaryTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	boolean balanced = true;
	int getHeight(TreeNode root){
		if(!balanced)
			return 0;
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		int h1 = getHeight(root.left);
		int h2 = getHeight(root.right);
		if(Math.abs(h1-h2)>1)
			balanced = false;
		return Math.max(h1, h2)+1;
	}
	
	
	public boolean isBalanced(TreeNode root) {
		getHeight(root);
		return balanced;
	}
	
}
