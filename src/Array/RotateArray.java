package Array;

import java.util.Arrays;

import org.junit.Test;
/** 
 * @author 闵大为
 * @date 2015年6月30日
 * @Description
 * 解题思路：
 * <li>方法1 开辟内存空间，保存k个变量，复制过去
 * <li>方法2 一个一个把它放到之前
 * <li>方法3 AB倒置，A、B分别倒置
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		k=k%nums.length;
		if(k==0) return;
		int[] k_nums = Arrays.copyOfRange(nums, nums.length-k, nums.length);
		for(int i=nums.length-1;i>=k;--i)
			nums[i]=nums[i-k];
		for(int i=k-1;i>=0;--i)
			nums[i]=k_nums[i];
    }
	
	@Test
	public void main(){
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
		for(int i:nums){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
