package Array;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月6日
 * @Description
 * 题目描述：</br>
 * 求字数组的最大乘积</br>
 * </br>
 * 解题思路：
 * <li>分治,分为Max(左边最大的，右边最大的，中间最大的)
 */

public class MaximumProductSubarray {
	int maxMid(int nums[],int bg ,int mid,int ed){
		int p_l_max = Integer.MIN_VALUE;
		int p_l_min = Integer.MAX_VALUE;
		int p = 1;
		for(int i=mid;i>=bg;--i){
			p*=nums[i];
			if(p>p_l_max)
				p_l_max=p;
			if(p<p_l_min)
				p_l_min=p;
		}
		int p_r_max = Integer.MIN_VALUE;
		int p_r_min = Integer.MAX_VALUE;
		p = 1;
		for(int i=mid+1;i<=ed;++i){
			p*=nums[i];
			if(p>p_r_max)
				p_r_max=p;
			if(p<p_r_min)
				p_r_min=p;
		}
		
		int v1 = p_l_max*p_r_max;
		int v2 = p_l_max*p_r_min;
		int v3 = p_l_min*p_r_max;
		int v4 = p_l_min*p_r_min;
		
		return Math.max(Math.max(v1, v2), Math.max(v3, v4));
	}
	
	int maxTotal(int nums[],int bg,int ed){
		if(bg==ed)
			return nums[bg];
		int mid = (bg+ed)>>1;
		int max_l = maxTotal(nums, bg, mid);
		int max_r = maxTotal(nums, mid+1, ed);
		int max_m = maxMid(nums, bg, mid, ed);
		return Math.max(max_m,Math.max(max_l, max_r));
	}

	public int maxProduct(int[] nums) {	
		return maxTotal(nums,0,nums.length-1);
    }	
    
    @Test
    public void main(){
    	int[] nums = {-2,3,-4};
    	System.out.println(maxProduct(nums));
    }
    
}
