package Tree;
/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * Given a binary tree, find its maximum depth.
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int _maxDepth(TreeNode root, int height) {
		if (root == null)
			return height;
		int hl = 1 + _maxDepth(root.left, 0);
		int hr = 1 + _maxDepth(root.right, 0);
		return Math.max(hl, hr);
	}

	public int maxDepth(TreeNode root) {
		return _maxDepth(root, 0);
	}
}
