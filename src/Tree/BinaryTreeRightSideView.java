package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 题目参考：https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
	
	 void visit(TreeNode root,int pos,List<Integer> ls){
		 if(root!=null){
			 if(pos>=ls.size()){
				 ls.add(root.val);
			 }else
				 ls.set(pos, root.val);
			 visit(root.left, pos+1, ls);
			 visit(root.right, pos+1, ls);
		 }
	 }
	
	 public List<Integer> rightSideView(TreeNode root) {
		 	List<Integer> ls = new ArrayList<Integer>();
		 	visit(root, 0, ls);
		 	return ls;
	 }
	 
	 @Test
	 public void main(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left  = t2;
		t1.right = t3;
		t2.right = t5;
		t3.left = t4;
		
		List<Integer> ls = rightSideView(t1);
		for(Integer i : ls)
			System.out.print(i+" ");
		System.out.println();
		
	 }
}
