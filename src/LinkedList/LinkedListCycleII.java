package LinkedList;

/**
 * @author 闵大为
 * @date 2015年7月25日
 * @Description
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null <br/>
 * <br/>
 * 经典分析，参考：
 * https://leetcode.com/discuss/47292/java-o-n-space-solution-with-detailed-explanation .<br/>
 */

public class LinkedListCycleII {
	 
	 public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	 }
	
	 public ListNode detectCycle(ListNode head) {
         if(head==null)
	    	 return null;
	     head.val = Integer.MAX_VALUE;
	     head=head.next;
	     while(head!=null){
	    	 if(head.val==Integer.MAX_VALUE)
	    		 return head;
	    	 else
	    		 head.val=Integer.MAX_VALUE;
	    	 head=head.next;
	     }
		 return null;
  }
}
