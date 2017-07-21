package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;
/**
 * @author 闵大为
 * @date 2015年8月5日
 * @Description
 * 题目参考：https://leetcode.com/problems/sum-root-to-leaf-numbers/ <br/>
 */
public class SumRootToLeafNumbers {
	 
	 void visit(TreeNode root,int val,List<Integer> ls){
		 if(root==null){
			 return;
		 }else{
			if(root.left==null&&root.right==null)
				ls.add( val*10+root.val);
			visit(root.left , val*10+root.val, ls); 
			visit(root.right, val*10+root.val, ls);
		 }
	 }
	
	  public int sumNumbers(TreeNode root) {
		  List<Integer> ls = new ArrayList<>();
		  visit(root, 0, ls);
		  int sum = 0;
		  for(int i:ls)
			  sum+=i;
		  return sum;
	  }
	  
	  @Test
	  public void main(){
		  TreeNode n1 = new TreeNode(3);
		  TreeNode n2 = new TreeNode(4);
		  TreeNode n3 = new TreeNode(5);
		  n1.left = n2;
		  n1.right = n3;
		  System.out.println(sumNumbers(n1));
	  }
}
