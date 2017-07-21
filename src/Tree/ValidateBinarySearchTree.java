package Tree;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月5日
 * @Description
 * 题目参考：https://leetcode.com/problems/validate-binary-search-tree/
 * <br/>
 * 解题思路：<br/>
 * <li> 1 Float.Min_value Double.Min_value 是可表示的最小正非零值的常量
 * <li> 2 可用long
 * <li> 3 参考：https://leetcode.com/discuss/49732/simple-java-solution-recursive-validation
 */

public class ValidateBinarySearchTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public boolean _isValidBST(TreeNode root,int min ,int max,boolean isMin,boolean isMax) {
		
        if(root==null)
        	return true;
        
        System.out.println(root.val+" "+min+" "+max+" "+isMin+" "+isMax);
        
        
        if(!(root.val>min&&root.val<max)){
        	 if(min==Integer.MIN_VALUE&&root.val==Integer.MIN_VALUE&&!isMin){
        		 isMin = true;
        		return _isValidBST(root.left,min,root.val,isMin,isMax)
        				&&_isValidBST(root.right,root.val,max,isMin,isMax);
              }else if(max==Integer.MAX_VALUE&&root.val==Integer.MAX_VALUE&&!isMax){
               	isMax = true;
               	return _isValidBST(root.left,min,root.val,isMin,isMax)
               			&&_isValidBST(root.right,root.val,max,isMin,isMax);
             }else
            	 return false;
        }else
        	return _isValidBST(root.left,min,root.val,isMin,isMax)&&_isValidBST(root.right,root.val,max,isMin,isMax);
    }
	
	public boolean isValidBST(TreeNode root) {
        if(root==null)
        	return true;
        return _isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE,false,false);
    }
	
	// [10,5,15,null,null,6,20]
	//[2147483647,null,-2147483648]
	//[2147483644,-2147483648,2147483646,null,null,2147483645,2147483647
	@Test
	public void main(){
		TreeNode t1 = new TreeNode(2147483644);
		TreeNode t2 = new TreeNode(-2147483648);
		TreeNode t3 = new TreeNode(2147483646);
		//TreeNode t4 = new TreeNode(3);
	//	TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(2147483645);
		TreeNode t7 = new TreeNode(2147483647);
		
		t1.left = t2;
		t1.right = t3;
		//t2.left = t4;
		//t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		System.out.println(isValidBST(t1));
	}
}
