package Array;

import static org.junit.Assert.*;
import org.junit.Test;


/** 
 * @author 闵大为 
 * @date 2015年7月17日
 * @Description
 * 
 * 题目描述：</br>
 * 在旋转重复数组中找到最小的数</br>
 * </br>
 * 解题思路：</br>
 * <li>根据排列特点使用二分法
 */
public class FindMinimumInRotatedSortedArrayII {
	
	public int findMinHelper(int[] nums,int bg,int ed){
		if(ed-bg<=1)
			return Math.min(nums[bg],nums[ed]);
		
		int mid = (bg+ed)>>1;  
		
		if(nums[bg]<nums[ed]){
			return findMinHelper(nums,bg,mid);
		}else if(nums[bg]>nums[ed]){
			if(nums[mid]>=nums[bg])
				return findMinHelper(nums,mid+1,ed);
			else
				return findMinHelper(nums,bg,mid);
		}else{
			int m1 = findMinHelper(nums,bg,mid);
			int m2 = findMinHelper(nums,mid+1,ed);
			return Math.min(m1, m2);
		}
	}

    public int findMin(int[] nums) {
    	int bg = 0;
    	int ed = nums.length-1;	
        return findMinHelper(nums,bg,ed);
    }
	
	@Test
	public void main(){
		int[][] nums = {
						{4,5,6,7,0,1,2},
						{3,3,1,3}
					};
		int[] answers = {0,1};
		for(int i = 0 ;i <nums.length;++i){
			assertEquals(answers[i], findMin(nums[i]));	
		}
		System.out.println("ok");
	}
}
