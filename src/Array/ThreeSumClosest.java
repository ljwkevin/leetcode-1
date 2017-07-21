package Array;

import java.util.Arrays;
import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月20日
 * @Description
 * 求三个数的和接近一个数</br>
 * </br>
 * 解题思路：</br>
 * 先排序，然后使用二分查找,比较接近的值</br>
 */
public class ThreeSumClosest {
	 public int threeSumClosest(int[] nums, int target) { 
		 int diff = Integer.MAX_VALUE;
		 Arrays.sort(nums);
		 for(int i=0;i<nums.length-2;++i)
			 for(int j=i+1;j<nums.length-1;++j){
				 int needNum = target-nums[i]-nums[j];
				 int k = Arrays.binarySearch(nums,j+1,nums.length, needNum);
				 if(k<0){
					 k = (k+1)*(-1);
					 if(k<=nums.length-1){
						 int t_diff =nums[i]+nums[j]+nums[k]-target;
						 if(Math.abs(t_diff)<=Math.abs(diff))
							 diff=t_diff;
					 }
					 if(k-1>=j+1){
						 int t_diff =nums[i]+nums[j]+nums[k-1]-target;
						 if(Math.abs(t_diff)<=Math.abs(diff))
							 diff=t_diff;
					 }
				 }else
					 return target;
			 }
		 return target+diff;
	 }
	 
	 @Test
	 public void main(){
		 int[] nums = {-1,2,1,-4};
		 int target = 1;
		 System.out.println(threeSumClosest(nums,target));
		 
	 }
}
