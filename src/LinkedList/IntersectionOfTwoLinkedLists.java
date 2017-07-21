package LinkedList;

import org.junit.Test;

import LinkedList.SwapNodesInPairs.ListNode;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 寻找插入点，统计个数，进入同一起跑线.<br/>
 */
public class IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	int gs(ListNode headA){
		int gs = 0;
		while(headA!=null){
			gs++;
			headA =  headA.next;
		}
		return gs;
	}
	
	ListNode go(ListNode head , int bs){
		while(bs>0){
			head=head.next;
			bs--;
		}
		return head;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null)
			return null;
		
		int gsA = gs(headA);
		int gsB = gs(headB);

		if(gsA>gsB){
			headA = go(headA,gsA-gsB);
		}else{
			headB = go(headB,gsB-gsA);			
		}
		
		while(headA!=null){
			if(headA==headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}

	
	@Test
	public void main(){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		ListNode node6 = new ListNode(6);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
	
		node6.next=node4;
	
		System.out.println(getIntersectionNode(node1,node6).val);
		
	}
	
		
}
