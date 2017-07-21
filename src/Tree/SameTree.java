package Tree;

/**
 * @author 闵大为
 * @date 2015年8月2日
 * @Description
 * 题目参考：https://leetcode.com/problems/same-tree/
 */
public class SameTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null&&q==null)
			 return true;
		 else if(p==null||q==null)
			 return false;
		 else{
			 if(p.val!=q.val)
				 return false;
			 else 
				 return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		 }
	 }
	
}
