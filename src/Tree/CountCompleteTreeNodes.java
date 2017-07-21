package Tree;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 参考：https://leetcode.com/discuss/47954/simple-java-solution
 */
public class CountCompleteTreeNodes {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	 public int countNodes(TreeNode root) {
		 if (root == null)
				return 0;
		 int h = 0;
		 TreeNode left = root;
		 while(left!=null){
			 h++;
			 left = left.left;
		 }
		 if(h<=1)
			 return h;
		 
		 int h0 = 0;
		 int gs = (int)Math.pow(2, h-1)-1;
		 
		 int total = (int)Math.pow(2, h-1);
		 
		 while(root != null){
			
			 TreeNode tRoot = root.left;
			 h0++;
				 
			 TreeNode right = tRoot;
			 int th = h0;
			 while(right!=null){
				 th++;
				 right=right.right;
			 }
			 if(total>1)
				 total/=2;
			 if(th==h){
				 gs+=total;
				 root = root.right;		
			 }else{
				 root = root.left;
			 }
		 }
		 
		 return gs;
	 }
	 
	 public int countNodes2(TreeNode root) {
		 if (root == null)
				return 0;
			int nl = countNodes(root.left);
			int nr = countNodes(root.right);
			return 1+nl+nr;
	    }
	 
	 @Test
		public void main(){
			TreeNode t1 = new TreeNode(1);
			TreeNode t2 = new TreeNode(2);
			TreeNode t3 = new TreeNode(3);
			TreeNode t4 = new TreeNode(4);
			TreeNode t5 = new TreeNode(5);
			TreeNode t6 = new TreeNode(6);
			TreeNode t7 = new TreeNode(7);
			
			t1.left = t2;
			t1.right = t3;
			
			//t2.left = t4;
			//t2.right = t5;
			
			//t3.left = t6;
			//t3.right = t7;
			
			System.out.println(countNodes(t1));
		}
}
