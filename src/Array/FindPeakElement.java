package Array;

import static org.junit.Assert.*;
import org.junit.Test;
/** 
 * @author 闵大为 
 * @date 2015年7月17日
 * @Description
 * 题目描述：</br>
 * A peak element is an element that is greater than its neighbors.</br>
 * </br>
 * 解题思路：</br>
 * <li>直接从前往后搜索
 */
public class FindPeakElement {
	 public int findPeakElement(int[] nums) {
		 if(nums.length==0)
			 return -1;
		 if(nums.length==1||nums[0]>nums[1])
			 return 0;
		 if(nums[nums.length-1]>nums[nums.length-2])
			 return nums.length-1;
		 for(int i=1;i<=nums.length-2;++i){
			 if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
				 return i;
		 }
		 return -1;
	 }
	 
	 @Test
	 public void main(){
		 int[][] nums ={{1, 2, 3, 1},
				        {1},
				        {2,1},
				        {1,2}
		 };
		 int[] answers = {2,0,0,1};
		 for(int i=0;i<nums.length;++i){
			 assertEquals(answers[i],findPeakElement(nums[i]));
		 }
		 System.out.println("OK!");
	 }
}
