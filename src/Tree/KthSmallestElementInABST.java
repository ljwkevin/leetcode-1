package Tree;

import org.junit.Test;

import Tree.MaximumDepthOfBinaryTree.TreeNode;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * TODO(这里用一句话描述这个类的作用)
 */
public class KthSmallestElementInABST {
		public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		}
		
		int treeNodeNum(TreeNode root) {
			if (root == null)
				return 0;
			int nl = treeNodeNum(root.left);
			int nr = treeNodeNum(root.right);
			return 1+nl+nr;
		}

		public int kthSmallest(TreeNode root, int k) {
			int nl = treeNodeNum(root.left);
			if(nl>=k){
				return kthSmallest(root.left,k);
			}else if(nl==k-1){
				return root.val;
			}else{
				return kthSmallest(root.right,k-nl-1);
			}
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
			
			t2.right = t3;
			t3.left = t1;
			t4.left = t2;
			t4.right = t6;
			t6.left = t5;
			t6.right = t7;
			
			System.out.println(kthSmallest(t4, 4));
		}
}
