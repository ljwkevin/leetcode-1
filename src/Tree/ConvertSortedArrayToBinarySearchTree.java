package Tree;

import java.util.Arrays;

import org.junit.Test;


public class ConvertSortedArrayToBinarySearchTree {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
	 
	 public TreeNode sortedArrayToBST(int[] nums) {
		  if(nums==null||nums.length==0)
			  return null;
		  int mid = nums.length/2; // 数组下标从0开始
		  TreeNode root = new TreeNode(nums[mid]);
		  root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
		  root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
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
		  int[] nums = {3,5,8};
			TreeNode node = sortedArrayToBST(nums);
			print(node);
			// 5 ,3 ,8
	  }
}
