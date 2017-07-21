package Tree;
/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 题目参考：https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode next = null;
		while(root!=null){
			next = root.left;
			if(next==null)
				return;
			TreeLinkNode pre = null;
			while(root!=null){
				if(pre!=null)
					pre.next = root.left;
				root.left.next=root.right;
				pre = root.right;
				root = root.next;
			}
			root=next;
		}
    }
}
