package DivideAndConquer;

import java.util.Arrays;
/**
 * @author �ɴ�Ϊ
 * @date 2015��7��27��
 * @Description
 * Ѱ�ҵ�K��Ԫ��.�������˼��ο���
 * https://leetcode.com/discuss/45627/ac-clean-quickselect-java-solution-avg-o-n-time <br/>
 */
public class KthLargestElementInAnArray {
	  public int findKthLargest(int[] nums, int k) {
		  Arrays.sort(nums);
		  return nums[nums.length-k];
	  }
}
