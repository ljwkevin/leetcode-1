package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Tree.KthSmallestElementInABST.TreeNode;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 二分查找树迭代器.<br/>
 * 经典算法参考：
 * https://leetcode.com/discuss/48255/nice-comparison-and-short-solution <br/>
 */
public class BinarySearchTreeIterator {
	
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	 }
	
	 class BSTIterator {
		void visit(TreeNode root,List<Integer> ls) {
			if (root == null)
				return ;
			ls.add(root.val);
			visit(root.left,ls);
			visit(root.right,ls);
		}

		int idx =0;
		List<Integer> ls = new ArrayList<>();

	    public BSTIterator(TreeNode root) {
	    	visit(root,ls);
	    	ls.sort((i1,i2)->{return i1-i2;});
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return idx<ls.size();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return ls.get(idx++);
	    }
	}
	 
	 /**
	  * Your BSTIterator will be called like this:
	  * BSTIterator i = new BSTIterator(root);
	  * while (i.hasNext()) v[f()] = i.next();
	  */
	 
	 @Test
	 public void main(){
		 
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t2.left = t1;
		t2.right = t3;
		t3.right = t7;
		t7.left = t4;
		t4.right = t5;
		t5.right = t6;
		
		BSTIterator i = new BSTIterator(t2);
		while (i.hasNext()) 
			System.out.print(i.next()+" ");
		System.out.println();
		
	 }
	 
	
	 
}
