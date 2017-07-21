package Tree;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年8月2日
 * @Description
 * 题目参考：https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	boolean isSame(TreeNode root1,TreeNode root2){
		if(root1==null&&root2==null)
			return true;
		else if(root1==null||root2==null)
			return false;
		else{
			if(root1.val!=root2.val)
				return false;
			else 
				return isSame(root1.left, root2.right)&&isSame(root1.right, root2.left);
		}
	}
	
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null)
			 return true;
		return isSame(root.left, root.right);
	 }
	
	
	@Test
	public void main(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(4);
		
		t1.left = t2;
		t1.right = t3;
		//t2.left = t4;
		t2.right = t5;
		//t3.left = t6;
		t3.right = t7;
		
		System.out.println(isSymmetric(t1));
	}
}
