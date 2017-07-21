package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 题目：https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ <br/>
 * 解决方案：使用两个堆栈进行处理. <br/>
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
		  			lses.add(ls);
		  		}
		  	}
		  	return lses;
	  }
	  
	  @Test
	  public void main(){
		    TreeNode t1 = new TreeNode(3);
			TreeNode t2 = new TreeNode(9);
			TreeNode t3 = new TreeNode(20);
			TreeNode t4 = new TreeNode(15);
			TreeNode t5 = new TreeNode(7);
			
			
			TreeNode t6 = new TreeNode(5);
			TreeNode t7 = new TreeNode(2);

			t1.left = t2;
			t1.right = t3;
			t2.left = t6;
			t2.right = t7;
			t3.left = t4;
			t3.right = t5;
			
			List<List<Integer>> lses = zigzagLevelOrder(t1);
			
			for(List<Integer> ls:lses){
				for(int i :ls)
					System.out.print(i+" ");
				System.out.println();
			}
			
	  }
}
