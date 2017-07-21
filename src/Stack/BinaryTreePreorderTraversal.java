package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import Tree.KthSmallestElementInABST.TreeNode;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 可以参考：
 * https://leetcode.com/discuss/46894/java-solution-both-recursion-and-iteration
 */
public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		if(root==null)
			return ls;
		Stack<TreeNode> stack  = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			ls.add(node.val);
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
		return ls;
	}

	@Test
	public void main() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left = t4;
		t1.right = t2;
		t2.left = t3;
		t2.right = t5;
		
		List<Integer> ls = preorderTraversal(t1);
		for(int i : ls)
			System.out.print(i+" ");
		System.out.println();
		
	}
}
