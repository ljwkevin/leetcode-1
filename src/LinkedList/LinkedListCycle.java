package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月25日
 * @Description
 * 求解是否存在圈，用最大的正数标记. <br/>
 * 比较好的方法，追及问题，参考 https://leetcode.com/discuss/44353/accepted-clean-java-solution .<br/>
 */

public class LinkedListCycle {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	 public boolean hasCycle(ListNode head) {
	     if(head==null)
	    	 return false;
	     head.val = Integer.MAX_VALUE;
	     head=head.next;
	     while(head!=null){
	    	 if(head.val==Integer.MAX_VALUE)
	    		 return true;
	    	 else
	    		 head.val=Integer.MAX_VALUE;
	    	 head=head.next;
	     }
		 return false;
	 }
	 
	@Test
	public void main(){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		//ListNode node6 = new ListNode(6);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node3;
	
		System.out.println(hasCycle(node1));
		
	}
	
}
