package LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 将链排序后的链表转换成平衡二叉树.参考：https://leetcode.com/discuss/38305/recursive-java-solution <br/>
 */
public class ConvertSortedListToBinarySearchTree {
	
	  public class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public TreeNode sortedListToBST(ListNode head) {
		  ListNode p = head;
		  int n =0;
		  while(p!=null){
			  p=p.next;
		  	  ++n;
		  }
		  if(n==0)
			  return null;
		  if(n==1)
			  return new TreeNode(head.val);
		  int len = n/2;
		  p = head;
		  len--;
		  while(len>0){
			  p = p.next;
			  len--;
		  }
		  
		  TreeNode root = new TreeNode(p.next.val);
		  root.right = sortedListToBST(p.next.next);
		  p.next=null;
		  root.left = sortedListToBST(head);
		  return root;
	  }
	  
	  
	  void print(TreeNode node){
		  if(node!=null){
			  print(node.left);
			  System.out.print(node.val+" ");
			  print(node.right);
		  }
	  }
	  
	  @Test 
	  public void main(){
		  	ListNode node1 = new ListNode(1);
			ListNode node2 = new ListNode(2);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			//ListNode node5 = new ListNode(5);
			
			node1.next=node2;
			node2.next=node3;
			node3.next=node4;
			//node4.next=node5;
		
			TreeNode node = sortedListToBST(node1);
			print(node);
			
	  }
}
