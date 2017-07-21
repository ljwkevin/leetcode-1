package Tree;

/**
 * @author �ɴ�Ϊ
 * @date 2015��8��2��
 * @Description
 * ��Ŀ�ο���https://leetcode.com/problems/same-tree/
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
