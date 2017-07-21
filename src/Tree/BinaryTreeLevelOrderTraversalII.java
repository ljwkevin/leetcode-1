package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author �ɴ�Ϊ
 * @date 2015��8��3��
 * @Description
 * ��Ŀ������https://leetcode.com/problems/binary-tree-level-order-traversal-ii/ <br/>
 * �㷨�ο���https://leetcode.com/discuss/49166/easy-java-solution-within-12-lines
 */
public class BinaryTreeLevelOrderTraversalII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lses = new ArrayList<List<Integer>>();
		visit(lses, root,0);
		Collections.reverse(lses);
		return lses;
	}
	void visit(List<List<Integer>> lses,TreeNode root,int level){
		if(root==null)
			return;
		if(level==lses.size()){
			lses.add(new ArrayList<>());
		}
		lses.get(level).add(root.val);
		visit(lses, root.left, level+1);
		visit(lses, root.right, level+1);
	}
	
}
