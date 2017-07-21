package LinkedList;

import org.junit.Test;

import LinkedList.RemoveDuplicatesFromSortedList.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 题目描述：<br/>
 * Given a sorted linked list, delete all nodes that have duplicate 
 * numbers, leaving only distinct numbers from the original list. <br/>
 * <br/>
 * 解题方法：<br/>
 * https://leetcode.com/discuss/37254/java-remove-duplicates-from-sorted-list-ii <br/>
 */
public class RemoveDuplicatesFromSortedListII {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	  public ListNode deleteDuplicates(ListNode head) {
		  
		  if(head==null||head.next==null)
			  return head;
		  
		  ListNode  p0 = null;
		  ListNode  p1 = head;
		  ListNode  p2 = head.next;
		  while(p2!=null){
			  if(p2.val==p1.val){
				  int val = p1.val;
				  while(p2.next!=null&&p2.next.val==val)
					  p2=p2.next;
				  
				  p1=p2.next;
				  p2=(p1==null?null:p1.next);
				  
				  if(p0!=null){
					 p0.next=p1;
				  }
				  
				  if(head.val == val)
					  head = p1;
				  
			  }else{
				  p0=p1;
				  p1=p2;
				  p2=p2.next;
			  }
		  }
		  return head;
	  }
	  
	  void print(ListNode head){
			while(head!=null){
				System.out.print(head.val+" ");
				head = head.next;
			}
			System.out.println();
		}
	  
	  	@Test
		public void main(){
			
			ListNode node1 = new ListNode(1);
			ListNode node2 = new ListNode(1);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			ListNode node5 = new ListNode(4);
			
			node1.next=node2;
			node2.next=node3;
			node3.next=node4;
			node4.next=node5;
			
			print(node1);
			ListNode node =  deleteDuplicates(node1);
			print(node);
			
		}
}
