package Tree;
/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 题目参考：https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode next = root;
		TreeLinkNode pre = null;
		while(next!=null){
			root = next;
			next = null;
			pre = null;
			
			while(root!=null){
			
				if(root.left!=null||root.right!=null){
					if(root.left!=null){
						if(next==null)
							next=root.left;
						if(pre==null)
							pre=root.left;
						else{
							pre.next=root.left;
							pre=root.left;
						}
					}
					if(root.right!=null){
						if(next==null)
							next=root.right;
						if(pre==null)
							pre=root.right;
						else{
							pre.next=root.right;
							pre=root.right;
						}
					}
				}
				
				root = root.next;
			}
		
		}
    }
	
}
