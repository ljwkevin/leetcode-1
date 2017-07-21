package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/**
 * @author 闵大为
 * @date 2015年8月3日
 * @Description
 * 题目参考：https://leetcode.com/problems/binary-tree-level-order-traversal/ <br/>
 * 解题参考：https://leetcode.com/discuss/49251/solution-without-queues-stacks-recursive-filling-resulting
 */
public class BinaryTreeLevelOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
	 	List<List<Integer>> lses = new ArrayList<List<Integer>>();
	  	if(root==null)
	  		return lses;
	  	
	  	Stack<TreeNode> s0 = new Stack<>();
	  	Stack<TreeNode> s1 = new Stack<>();
	  	s0.push(root);
	  	
	  	while(!s0.isEmpty()||!s1.isEmpty()){
	  	  	List<Integer> ls = new ArrayList<Integer>();
	  		if(!s0.isEmpty()){
	  			while(!s0.isEmpty()){
	  				TreeNode node =  s0.pop();
	  				ls.add(node.val);
	  				if(node.left!=null)
	  					s1.push(node.left);
	  				if(node.right!=null)
	  					s1.push(node.right);
	  			}
	  			lses.add(ls);
	  		}else{
	  			while(!s1.isEmpty()){
	  				TreeNode node =  s1.pop();
	  				ls.add(node.val);
	  				if(node.right!=null)
	  					s0.push(node.right);
	  				if(node.left!=null)
	  					s0.push(node.left);
	  			}
	  			Collections.reverse(ls);
	  			lses.add(ls);
	  		}
	  	}
	  	return lses;
	}
}