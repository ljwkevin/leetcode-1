package Tree;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author �ɴ�Ϊ
 * @date 2015��8��6��
 * @Description
 * ��Ŀ�ο���https://leetcode.com/problems/recover-binary-search-tree/ <br/>
 * ����˼·�� �ҳ�ǰ���С��ϵ��һ���ĵ�<br/>
 * ������á�������<br/>
 * https://leetcode.com/discuss/34421/java-ac-solution-using-constant-space-2-extra-pointers
 */
public class RecoverBinarySearchTree {
	 TreeNode pre = null;
	 TreeNode p1 = null;
	 TreeNode p2 = null; 
	 boolean isFind = false;
     void preVisit(TreeNode root){
    	 if(isFind)
    		 return;
    	 if(root!=null){
    		 preVisit(root.left);
    		 if(pre==null)
    			 pre = root;
    		 else{
    			 if(p1==null){
    				 if(pre.val>root.val){
    					 p1=pre;
    					 p2=root;
    				 }
    			 }else{
    				 if(root.val>p1.val){
    					 isFind=true;
    					 return;
    				 }else if(root.val<p2.val){
    					 p2=root;
    					 isFind=true;
    					 return;
    				 }
    			 }
    			 pre = root;
    		 }
    		 preVisit(root.right);
    	 }
     }
	
	 public void recoverTree(TreeNode root) {
		preVisit(root);
		int tmp = p1.val;
		p1.val = p2.val;
		p2.val = tmp;
	 }
	 
	 @Test
	 public void main(){
		
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t4.right = t5;
		
		TreeUtil.print(t1);
		recoverTree(t1);
		TreeUtil.print(t1);
		
	 }
	 
}
