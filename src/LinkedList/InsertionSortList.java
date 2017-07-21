package LinkedList;

import org.junit.Test;

import LinkedList.MergeTwoSortedLists.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 插入排序. <br/>
 */
public class InsertionSortList {
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
	
	
	 public ListNode insertionSortList(ListNode head) {
		 	if(head==null)
		 		return null;
		 	ListNode pre = new ListNode(0);
		 	ListNode pi = head;
		 	while(pi!=null){
		 		ListNode pj = pre;
		 		while(pj.next!=null&&pj.next.val<pi.val){
		 			pj=pj.next;
		 		}
		 		ListNode tmp = pi.next;
		 		pi.next = pj.next;
		 		pj.next = pi;
		 		pi = tmp;
		 	}
	        return pre.next;
	  }
	
	@Test
	public void main(){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		
		//ListNode node6 = new ListNode(6);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
	
		ListNode node = insertionSortList(node1);
		
		print(node);
		
	}
	
	

	
}
