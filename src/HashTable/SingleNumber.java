package HashTable;

import java.util.Arrays;

import org.junit.Test;

/** 
 * @author 闵大为
 * @date 2015年7月21日
 * @Description
 * 题目描述:</br>
 * Given an array of integers, every element appears
 * twice except for one. Find that single one. </br>
 * </br>
 * 解题思路:</br>
 * 先排序，再遍历.</br>
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1)
        	return nums[0];
        for(int i=0;i<nums.length-1;i+=2){
        	if(nums[i]!=nums[i+1])
        		return nums[i];
        }
        return nums[nums.length-1];
    }
	
	@Test
	public void main(){
		int[] nums = {1,2,3,2,1};
		System.out.println(singleNumber(nums));
	}
	
}
