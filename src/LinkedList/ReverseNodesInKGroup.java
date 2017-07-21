package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月25日
 * @Description
 * 头插法实现反转. <br/>
 */
public class ReverseNodesInKGroup {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	void print(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	 public ListNode reverseKGroup(ListNode head, int k) {
	  if(head==null||k<=1)
		  return head;
	  
	  ListNode p =head;
	  int n=0;
	  while(p!=null){
		  n++;
		  p=p.next;
	  }
	  if(k>n)
		  return head;
	  
	  ListNode first = new ListNode(0);
	  first.next=head;
	  
	  ListNode pre = first;
	  ListNode tail = null;
	  ListNode tmp = null;
	  while(n>=k){
		  p = pre.next;
		  tail = pre.next;
		  tmp =null;
		  int cs = k;
		  while(cs>0){
			  tmp = p.next;
			  p.next=pre.next;
			  pre.next=p;
			  p=tmp;
			  cs--;
		  }
		  tail.next=tmp;
		  pre =tail;
		  n-=k;
	  }
	  return first.next;
	 }
	
	@Test
	public void main(){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		print(node1);
		
		ListNode node = reverseKGroup(node1,5);
		print(node);
		
	}
}
