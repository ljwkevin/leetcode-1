package DivideAndConquer;

import java.util.Arrays;
/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 寻找第K大元素.经典快排思想参考：
 * https://leetcode.com/discuss/45627/ac-clean-quickselect-java-solution-avg-o-n-time <br/>
 */
public class KthLargestElementInAnArray {
	  public int findKthLargest(int[] nums, int k) {
		  Arrays.sort(nums);
		  return nums[nums.length-k];
	  }
}
