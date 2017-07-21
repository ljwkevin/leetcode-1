package LinkedList;

import java.util.ArrayList;
import java.util.List;
/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 倒叙，直接交换值. <br/>
 */
public class ReverseLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	 public ListNode reverseList(ListNode head) {
	     List<Integer> ls = new ArrayList<>(); 
		 ListNode p = head;
	     while(p!=null){
	    	 ls.add(p.val);
	    	 p=p.next;
	     }
	     
	     p = head;
	     for(int i=ls.size()-1;i>=0;--i){
	    	 p.val=ls.get(i);
	    	 p=p.next;
	     }
	     
		 return head;
	  }
}
