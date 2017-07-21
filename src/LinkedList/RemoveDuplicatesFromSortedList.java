package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 移除重复元素. <br/>
 */
public class RemoveDuplicatesFromSortedList {
	
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
		  
		  ListNode  p1 = head;
		  ListNode  p2 = head.next;
		  while(p2!=null){
			  if(p2.val==p1.val){
				  p1.next=p2.next;
				  p2=p1.next;
			  }else{
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
			ListNode node3 = new ListNode(2);
			ListNode node4 = new ListNode(3);
			ListNode node5 = new ListNode(3);
			
			node1.next=node2;
			node2.next=node3;
			node3.next=node4;
			node4.next=node5;
			
			print(node1);
			ListNode node =  deleteDuplicates(node1);
			print(node);
			
		}
}
