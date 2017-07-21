package Array;

import org.junit.Test;

/** 
 * @author �ɴ�Ϊ
 * @date 2015��6��25��
 * @Description
 * ����˼·��
 * <li> һ�α����ҵ� <code> target</code>С�ڵ���<cdoe>nums[i]</cdoe>
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
