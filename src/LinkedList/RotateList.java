package LinkedList;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月25日
 * @Description
 * 旋转链表，设置一个晚启动的指针.<br/>
 */
public class RotateList {
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
	
	public ListNode rotateRight(ListNode head, int k) {
		
		if(head==null||k<=1)
			return head;
		int gs = 0; 
		ListNode p =head;
		while(p!=null){
			gs++;
			p=p.next;
		}
		k=k%gs;
		if(k==0)
			return head;
		
		ListNode pSlow = head;
		ListNode pFast = head;
		while(pFast.next!=null){
			if(k>0)
				k--;
			else
				pSlow = pSlow.next; 
			pFast=pFast.next;
		}
		
		pFast.next=head;
		head = pSlow.next;
		pSlow.next=null;
		
		return head;
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
		
		ListNode node = rotateRight(node1,2);
		print(node);
		
	}
	
}
