package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月25日
 * @Description
 * 题目描述:<br/>
 * Sort a linked list in O(n log n) time using constant space complexity.<br/>
 * <br/>
 * 解题思路:<br/>
 * 1 归并排序... <br/>
 */
public class SortList {
		
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
		
//	ListNode _sort(ListNode pre ,int len){ 
//
//		ListNode p1 = pre.next;
//		ListNode p2 = pre;
//		
//		int n1 = 0;
//		while(n1<len&&p2!=null) {
//			n1++;
//			p2 = p2.next;	
//		}
//		if(p2==null)
//			return null;
//		
//		int n2 = len;
//		p2 = p2.next;
//		
//		while(p1!=null&&n1>0&&p2!=null&&n2>0){
//			if (p1.val < p2.val) {
//				pre.next = p1;
//				pre = p1;
//				p1 = p1.next;
//				n1--;
//			} else {
//				pre.next = p2;
//				pre = p2;
//				p2 = p2.next;
//				n2--;
//			}
//		}
//	
//		while (p1 != null && n1>0) {
//			pre.next = p1;
//			pre = p1;
//			p1 = p1.next;
//			n1--;
//		}
//		
//		while (p2 != null && n2>0) {
//			pre.next = p2;
//			pre = p2;
//			p2 = p2.next;
//			n2--;
//		}
//		
//		pre.next=p2;
//		return pre;
//	}
//		
//
//	public ListNode sortList(ListNode head) {
//		int total = 0;
//		ListNode p = head;
//		while (p != null) {
//			total++;
//			p = p.next;
//		}
//
//		ListNode first = new ListNode(0);
//		first.next = head;
//
//		int len =1;
//	
//		while(len<total){
//			p =first;
//			do{
//				p = _sort(p, len);
//			}while(p!=null);
//			
//			len*=2;
//		}
//		return first.next;
//	}
	  
	  
	  void print(ListNode head) {
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}

		@Test
		public void main() {
			ListNode node1 = new ListNode(5);
			ListNode node2 = new ListNode(1);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			ListNode node5 = new ListNode(2);
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			node4.next = node5;
			print(node1);

			//_sort(node1,3);;

			print(sortList(node1));

		}

		private  ListNode sortList(ListNode head) {
			
			if(head==null||head.next==null){
				return head;
			}
			
			ListNode pre = null,slow=head,fast=head;
			while(fast!=null && fast.next!=null){
				pre = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			
			pre.next = null;
			
			return merge(sortList(head),sortList(slow));
		}

		private ListNode merge(ListNode p0, ListNode p1) {
			
			ListNode head = new ListNode(0),tail=head;
			
			while(p0!=null&&p1!=null){
				if(p0.val<=p1.val){
					tail.next = p0;
					p0 = p0.next;
				}else{
					tail.next = p1;
					p1 = p1.next;
				}
				tail = tail.next;
			}
			
			if(p0!=null){
				tail.next = p0;
			}
			
			if(p1!=null){
				tail.next = p1;
			}
			
			return head.next;
			
		}
}
