package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 闵大为
 * @date 2015年7月21日
 * @Description
 * 题目描述：</br>
 * 中序遍历二叉树.</br>
 */
public class BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	void _inorderTraversal(TreeNode root,List<Integer> result){
		if(root==null)
			return;
		_inorderTraversal(root.left, result);
		result.add(root.val);
		_inorderTraversal(root.right, result);
	}
	
	
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> result = new ArrayList<>();
		 _inorderTraversal(root,result);
		 return result;
	 }
}
