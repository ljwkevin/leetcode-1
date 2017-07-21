package Tree;
/**
 * @author 闵大为
 * @date 2015年8月2日
 * @Description
 * 题目参考：https://leetcode.com/problems/path-sum/
 */
public class PathSum {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		if(root.left==null&&root.right==null)
			return root.val == sum;
		if(root.left!=null)
			if(hasPathSum(root.left, sum-root.val))
				return true;
		if(root.right!=null)
			if(hasPathSum(root.right, sum-root.val))
				return true;
		return false;
	}
}
