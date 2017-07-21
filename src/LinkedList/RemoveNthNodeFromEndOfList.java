package LinkedList;

import org.junit.Test;

import LinkedList.SwapNodesInPairs.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 删除倒数第几个节点.设置一个计数的，晚启动几步. <br/>
 */
public class RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = new ListNode(0);
		first.next = head;
		ListNode p = first;
		while(head!=null){
			head = head.next;
			if(n>0){
				n--;
			}else{
				p=p.next;
			}
		}
		p.next = p.next.next;
		return first.next;
	}

	void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
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
		
		ListNode node = removeNthFromEnd(node1,1);
		
		print(node);
		
	}
}
