package LinkedList;

import java.util.ArrayList;
import java.util.List;
/**
 * @author �ɴ�Ϊ
 * @date 2015��7��24��
 * @Description
 * ����ֱ�ӽ���ֵ. <br/>
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
