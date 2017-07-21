package LinkedList;


import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * 将后半部分倒叙插入前半部分.<br/>
 */

public class ReorderList {
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
	
	 public void reorderList(ListNode head) {
		 	if(head==null)
		 		return;
		 	
		 	int n = 0;
		 	ListNode p = head;
		 	while(p!=null){
		 		p = p.next;
		 		n++;
		 	}
		 	int n0 = (n-1)/2+1;
	      
		 	p = head;
		 	while(n0>1){
		 		p=p.next;
		 		n0--;
		 	}
		 	
		 	ListNode tmp = p;
		 	p = p.next;
		 	tmp.next = null;
		
		 	ListNode first = new ListNode(0);
		 	while(p!=null){
		 		tmp = p.next;
		 		p.next = first.next;
		 		first.next = p;
		 		p = tmp;
		 	}
		 	
		 	ListNode head2 =first.next;
		 	while(head2!=null){
		 		tmp = head2.next;
		 		head2.next = head.next;
		 		head.next = head2;
		 		head = head2.next;
		 		head2 = tmp;
		 	}
	 }
	
	
	@Test
	public void main(){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		//node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		print(node1);
		
		reorderList(node1);
		
		print(node1);
		
	}
	
}
