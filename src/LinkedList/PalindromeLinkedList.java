package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * 判断是否回文. 前半部分顺序，后半部分倒叙，进行比较. <br/>
 */
public class PalindromeLinkedList {
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
	 
    public boolean isPalindrome(ListNode head) {
    	int gs = 0;
    	ListNode p = head;
    	while(p!=null){
    		gs++;
    		p = p.next;
    	}
    	if(gs==0)
    		return true;
    	int lLen = (gs-1)/2+1;   	
        int rLen = gs - lLen;
        
        boolean isGO = lLen>rLen;
         
    	ListNode left = new ListNode(0);
    	ListNode right = new ListNode(0);
    	ListNode rTail = right;
    	ListNode tmp = null;
    	p = head;

        while(lLen>0){
        	tmp = p.next;
        	p.next = left.next;
        	left.next = p;
        	p = tmp;
        	lLen--;
        }
        while(rLen>0){
        	tmp = p.next;
        	rTail.next = p;
        	p.next = null;
        	rTail = p;
        	p = tmp;
        	rLen--;
        }
        if(rTail!=null)
        	rTail.next = null;
        
        if(isGO)
        	left = left.next;
        
        if(left!=null){
        	  left = left.next;
              right = right.next;
        }
           
        while(left!=null){
        	if(left.val!=right.val)
        		return false;
        	left =left.next;
        	right = right.next;
        }
        return true;
    }
    
    @Test
	public void main() {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		print(node1);

		System.out.println(isPalindrome(node1));

	}
    
}
