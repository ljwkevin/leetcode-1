package LinkedList;

import org.junit.Test;

/**
 * @author �ɴ�Ϊ
 * @date 2015��7��24��
 * @Description
 * �����ڵ�<br/>
 */
public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		
		ListNode lsNew = null;
		ListNode p = null;
		ListNode p1 = head;
		ListNode p2 = head.next;
		 
		while(p2!=null){
			if(p==null){
				lsNew = p2;
			}else{
				p.next=p2;
			}
			// ����
			p1.next=p2.next;
			p2.next=p1;
			// ǰ��
			p=p1;
			p1=p.next;
			if(p1==null)
				p2=null;
			else
				p2=p1.next;
		}
		return lsNew;
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
		ListNode node2 = new ListNode(2);
		/*ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);*/
		node1.next=node2;
		/*node2.next=node3;
		node3.next=node4;
		node4.next=node5;*/
		print(node1);
		
		ListNode node = swapPairs(node1);
		print(node);
		
	}
}
