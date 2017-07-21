package Array;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月17日
 * @Description
 * 
 * 题目描述</br>
 * Given an unsorted integer array, find the first missing positive integer.
 * Your algorithm should run in O(n) time and uses constant space.</br>
 * </br>
 * 解题思路：</br>
 * 1 我用了O(n)的存储空间</br>
 * 2 可以在原来的地方换，不需要给定之外的额外空间,见方法 <code>firstMissingPositive2<code> </br>
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int num:nums){
			if(num>0){
				if(num>max)
					max = num;
				if(num<min)
					min = num;
			}
		}
		
		if(min==Integer.MAX_VALUE||min>1)
			return 1;
		
		int length = max-min+1;
		int[] pNums = new int[length];
		for(int num:nums){
			if(num>0)
				pNums[num-min]=1;
		}
		int i;
		for(i=min;i<=max;++i){
			if(pNums[i-min]==0)
				return i;
		}
		return i;
    }

	int firstMissingPositive2(int[] nums) {
		if (nums.length == 0)
			return 1;
		int next, current;
		int i;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}
		for (i = 0; i < nums.length; i++) {
			current = nums[i];
			while (current > 0 && current <= nums.length) {
				next = nums[current - 1];
				nums[current - 1] = 0;
				current = next;
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				return i + 1;
		}
		return i + 1;
	}
	


	@Test
	public void main(){
		int[][] testNums ={
				{1,2,0},
				{3},
				{3,4,-1,1},
				{2},
				{0},
				{1},
				{},
				{1},
				{2},
				{1}
		};
		for(int i=0;i<testNums.length;i+=2){
			assertEquals("fail at "+i,testNums[i+1][0],firstMissingPositive(testNums[i]));
		}
		System.out.println("OK!");
		
	}
}
