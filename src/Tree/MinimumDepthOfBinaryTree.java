package Tree;
/**
 * @author �ɴ�Ϊ
 * @date 2015��8��2��
 * @Description
 * ��Ŀ�ο���https://leetcode.com/problems/minimum-depth-of-binary-tree/ <br/>
 * ����ο���https://leetcode.com/discuss/49422/java-recursive-solution
 */
public class MinimumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		if(root.left!=null||root.right!=null){
			int hl = Integer.MAX_VALUE;
			int hr = Integer.MAX_VALUE;
			if(root.left!=null)
				hl = 1 + minDepth(root.left);
			if(root.right!=null)
				hr = 1 + minDepth(root.right);
			return Math.min(hl, hr);
		}else
			return 1;
	}
}
