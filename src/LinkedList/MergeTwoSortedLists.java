package LinkedList;

import org.junit.Test;

import LinkedList.PalindromeLinkedList.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * 合并两个链表. <br/>
 * 可以用递归！！！ 参考： https://leetcode.com/discuss/43149/a-simple-recursive-solution-java .<br/>
 */
public class MergeTwoSortedLists {
	
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
	 
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode pre = new ListNode(0);
		 ListNode tail = pre;
		 while(l1!=null&&l2!=null){
			 if(l1.val<l2.val){
				 tail.next = l1;
				 tail = l1;
				 l1 = l1.next;
			 }else{
				 tail.next = l2;
				 tail = l2;
				 l2 = l2.next;
			 }
		 }
		 
		 while(l1!=null){
			 tail.next = l1;
			 tail = l1;
			 l1 = l1.next;
		 }
		 
		 while(l2!=null){
			 tail.next = l2;
			 tail = l2;
			 l2 = l2.next;
		 }
		 
		 if(tail!=null)
			 tail.next = null;
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
		
			node3.next=node4;
			node4.next=node5;
			
			ListNode node = mergeTwoLists(node1,node3);
			
			print(node);
			
		}
	 
	 
}
