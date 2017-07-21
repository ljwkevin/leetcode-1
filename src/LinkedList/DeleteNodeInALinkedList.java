package LinkedList;

import LinkedList.SwapNodesInPairs.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 删除一个节点,根据节点的前后关系进行删除.<br/>
 */
public class DeleteNodeInALinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 public void deleteNode(ListNode node) {
		 node.val=node.next.val;
		 node.next=node.next.next;
	 }
}
