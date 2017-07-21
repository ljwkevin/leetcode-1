package LinkedList;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 求和，可以参考：https://leetcode.com/discuss/45175/accepted-java-solution-428ms
 * (简明但是耗费空间).<br/>
 */
public class AddTwoNumbers {
	  public class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	  
		void print(ListNode head) {
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
		
		 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		        int jw = 0;
		        ListNode pre = new ListNode(0);
		        ListNode tail = pre;
		        
			 	while(l1!=null&&l2!=null){
		        	int val = l1.val+l2.val+jw;
		        	if(val>=10){
		        		val -=10;
		        		jw = 1;
		        	}else
		        		jw =0;
		        	
		        	l1.val = val;
		        	tail.next = l1;
		        	tail = l1;
		        	
		        	l1 = l1.next;
		        	l2 = l2.next;
		        }
			 	
			 	while(l1!=null){
			 		int val = l1.val+jw;
		        	if(val>=10){
		        		val -=10;
		        		jw = 1;
		        	}else
		        		jw =0;
		        	l1.val = val;
		        	tail.next = l1;
		        	tail = l1;
		        	l1 = l1.next;
			 	}
			 	
			 	while(l2!=null){
			 		int val = l2.val+jw;
		        	if(val>=10){
		        		val -=10;
		        		jw = 1;
		        	}else
		        		jw =0;
		        	l2.val = val;
		        	tail.next = l2;
		        	tail = l2;
		        	l2 = l2.next;
			 	}
			 	
			 	if(jw>0)
			 		tail.next = new ListNode(1);
			 	else
			 		tail.next = null;
			 	return pre.next;
		    }
		
		@Test 
		  public void main(){
			  	ListNode node1 = new ListNode(2);
				ListNode node2 = new ListNode(4);
				ListNode node3 = new ListNode(5);
				
				ListNode node4 = new ListNode(5);
				ListNode node5 = new ListNode(6);
				ListNode node6 = new ListNode(4);
			
				
				node1.next=node2;
				//node2.next=node3;
				
				node4.next=node5;
				node5.next=node6;
				
				ListNode node = addTwoNumbers(node1,node4);
				print(node);
				
		  }
}
