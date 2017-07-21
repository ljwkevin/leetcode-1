package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �ɴ�Ϊ
 * @date 2015��7��21��
 * @Description
 * ��Ŀ������</br>
 * �������������.</br>
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
