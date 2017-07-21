package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author 闵大为
 * @date 2015年8月5日
 * @Description
 * 解题参考：https://leetcode.com/discuss/46629/my-recursive-solution-is-easy-and-clean
 */
public class FlattenBinaryTreeToLinkedList {
	
	void preVisit(TreeNode root,List<Integer> ls){
		if(root!=null){
			ls.add(root.val);
			preVisit(root.left, ls);
			preVisit(root.right, ls);
		}
	}
	
	public void flatten(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		preVisit(root, ls);
		TreeNode pre = root;
		for(int i=1;i<ls.size();++i){
			TreeNode node = new TreeNode(ls.get(i));
			pre.left = null;
			pre.right = node;
			pre = node;
		}
	}
	
	
	 public void flatten2(TreeNode root) {
		 if(root==null)
			 return;
		 Stack<TreeNode> stack = new Stack<>();
		 stack.push(root);
		 TreeNode pre = null;
		 while(!stack.isEmpty()){
			 if(pre!=null){
				 pre.right = stack.peek();
			 }
			 pre = stack.pop();
			 if(pre.right!=null)
				 stack.push(pre.right);
			 if(pre.left!=null)
				 stack.push(pre.left);
		 }
	 }
	 
	 @Test
	 public void main(){
		 //[5,2,-2,4,-4,-9,2,7,2,null,-9,-9,null,null,3,null,7,null,null,null,null,null,null,null,3]
			TreeNode t1 = new TreeNode(1);
			TreeNode t2 = new TreeNode(2);
			TreeNode t3 = new TreeNode(-2);
			TreeNode t4 = new TreeNode(4);
			TreeNode t5 = new TreeNode(-4);
			TreeNode t6 = new TreeNode(-9);
			TreeNode t7 = new TreeNode(2);
			TreeNode t8 = new TreeNode(7);
			TreeNode t9 = new TreeNode(2);
			TreeNode t10 = new TreeNode(-9);
			TreeNode t11 = new TreeNode(-9);
			TreeNode t12 = new TreeNode(3);
			TreeNode t13 = new TreeNode(7);
			TreeNode t14 = new TreeNode(3);
			
			t1.left = t2;
			//t1.right = t3;
			
			//t2.left = t4;
			//t2.right = t5;
		
			t3.left = t6;
			t3.right = t7;
			
			t4.left = t8;
			t4.right = t9;
			
			t5.right = t10;
			
			t6.left = t11;
			
			t7.right = t12;
			
			t8.right = t13;
			
			t12.right = t14;
			
			flatten(t1);
			
			while(t1!=null){
				System.out.print(t1.val+" ");
				t1=t1.right;
			}
			System.out.println();
			
	 }
}
