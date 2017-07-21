package Array;

import org.junit.Test;

/** 
 * @author 闵大为
 * @date 2015年6月25日
 * @Description
 * 解题思路：
 * <li> 一次遍历找到 <code> target</code>小于等于<cdoe>nums[i]</cdoe>
 */
public class SearchInsertPosition {
	 public int searchInsert(int[] nums, int target) {
	     if(nums.length==0)
	    	 return 0;
		 for(int i=0;i<nums.length;++i)
	        if(target<=nums[i])
	        	return i;
		 return nums.length;
	 }
	 
	 @Test
	 public void main(){
		 int[] nums = {1,3,5,6};
		 System.out.println(searchInsert(nums, 5));
		 System.out.println(searchInsert(nums, 2));
		 System.out.println(searchInsert(nums, 7));
		 System.out.println(searchInsert(nums, 0));
	 };
}
