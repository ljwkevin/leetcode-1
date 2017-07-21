package LinkedList;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * 按值划分，分为两个链表然后合并. <br/>
 */
public class PartitionList {
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
	 
	  	public ListNode partition(ListNode head, int x) {
	  		/*List<Integer> lsSmall = new ArrayList<>();
	  		List<Integer> lsBig = new ArrayList<>();
	  		ListNode p = head;
	  		while(p!=null){
	  			if(p.val<x)
	  				lsSmall.add(p.val);
	  			else
	  				lsBig.add(p.val);
	  			p=p.next;
	  		}
	  		lsSmall.sort((i1,i2)->{return i1-i2;});
	  		lsBig.sort((i1,i2)->{return i1-i2;});
	  		p = head;
	  		for(int i :lsSmall){
	  			p.val = i;
	  			p = p.next;
	  		}
	  		for(int i :lsBig){
	  			p.val = i;
	  			p = p.next;
	  		}
	  		return head;*/
	  		ListNode sPre = new ListNode(0);
	  		ListNode sTail = sPre;
	  		ListNode bPre = new ListNode(0);	
	  		ListNode bTail = bPre;
	  		while(head!=null){
	  			ListNode tmp = head.next;
	  			if(head.val<x){
	  				sTail.next = head;
	  				head.next = null;
	  				sTail = head;
	  			}else{
	  				bTail.next = head;
	  				head.next = null;
	  				bTail = head;
	  			}
	  			head = tmp;
	  		}
	  		
	  		
	  		
	  		sTail.next = bPre.next;
	  		return sPre.next;
	    }

		@Test
		public void main() {
			ListNode node1 = new ListNode(4);
			ListNode node2 = new ListNode(3);
			ListNode node3 = new ListNode(2);
			ListNode node4 = new ListNode(5);
			ListNode node5 = new ListNode(2);
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			node4.next = node5;
			print(node1);

			//_sort(node1,3);;
			ListNode node =partition(node1,3);
			print(node);

		}
	
	
}
