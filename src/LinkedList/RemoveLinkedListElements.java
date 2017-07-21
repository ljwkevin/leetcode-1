package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * 移除指定值的节点. <br/>
 */
public class RemoveLinkedListElements {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 void print(ListNode head) {
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	 
	  public ListNode removeElements(ListNode head, int val) {
	        ListNode pre = new ListNode(0);
	        ListNode tail = pre;
	        while(head!=null){
	        	ListNode tmp = head.next;
	        	if(head.val!=val){		
	        		tail.next = head;
	        		head.next = null;
	        		tail = head;
	        	}
	        	head = tmp;
	        }
	        return pre.next;   
	    }

		@Test
		public void main() {
			ListNode node1 = new ListNode(5);
			ListNode node2 = new ListNode(4);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			ListNode node5 = new ListNode(2);
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			node4.next = node5;
			print(node1);

			//_sort(node1,3);;
			ListNode node =removeElements(node1,1);
			print(node);

		}
	
	
}
