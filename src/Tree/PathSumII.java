package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月2日
 * @Description
 * 题目参考：https://leetcode.com/problems/path-sum-ii/ <br/>
 * 解题参考：https://leetcode.com/discuss/47331/short-java-solution-with-dfs
 */
public class PathSumII {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	public void hasPathSum(TreeNode root, int sum, List<Integer> ls,List<List<Integer>> lses) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null){
			if(root.val == sum){
				ls.add(sum);
				lses.add(ls);
			}
			return;
		}
		if(root.left!=null){
			List<Integer> t_ls = new ArrayList<Integer>();
			for(Integer i:ls)
				t_ls.add(i);
			t_ls.add(root.val);
			hasPathSum(root.left, sum-root.val,t_ls,lses);
		}
		if(root.right!=null){
			List<Integer> t_ls = new ArrayList<Integer>();
			for(Integer i:ls)
				t_ls.add(i);
			t_ls.add(root.val);
			hasPathSum(root.right, sum-root.val,t_ls,lses);
		}
	}
	
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
		 List<List<Integer>> lses  = new ArrayList<>();
		 List<Integer> ls = new ArrayList<Integer>();
		 hasPathSum(root, sum, ls, lses);
		 return lses;
	 }
	 
	 @Test
	 public void main(){
		 TreeNode root = new TreeNode(1);
		 TreeNode r1 = new TreeNode(2);
		 root.left = r1;
		 List<List<Integer>> lses = pathSum(root, 3);
		for(List<Integer> ls :lses){
			for(int i :ls)
				System.out.print(i+"　");
			System.out.println();
		}
	 }
}
