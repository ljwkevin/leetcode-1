package Tree;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月4日
 * @Description
 * 题目描述：https://leetcode.com/problems/binary-tree-maximum-path-sum/ <br/>
 * 解题思路：对于每个根节点，考虑通过该节点的最大值  参考：https://leetcode.com/discuss/43797/elegant-java-solution <br/>
 */
public class BinaryTreeMaximumPathSum {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	int max = Integer.MIN_VALUE;
	public int _maxPathSum(TreeNode root) {
		if(root==null)
			return 0;
		int mid = root.val;
		int lf = _maxPathSum(root.left);
		int rg = _maxPathSum(root.right);
		if(lf+rg+mid>max)
			max=lf+rg+mid;
		
		int tmax = mid;
		if(lf+mid>tmax)
			tmax=lf+mid;
		if(rg+mid>tmax)
			tmax=rg+mid;
		if(tmax>max)
			max= tmax;
		//System.out.println(root.val+" "+lf+" "+rg+" "+tmax);
		return tmax;
	}
	
	public int maxPathSum(TreeNode root) {
		_maxPathSum(root);
		return max;
	}
	
	@Test
	public void main(){
		TreeNode t1 = new TreeNode(-9);
		TreeNode t2 = new TreeNode(-3);
		TreeNode t3 = new TreeNode(-1);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(8);
		TreeNode t7 = new TreeNode(-12);
		
		//t1.left = t2;
		//t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		System.out.println(maxPathSum(t1));
	}
}
