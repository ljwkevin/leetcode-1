package Array;

import org.junit.Test;
import static org.junit.Assert.*;
/** 
 * @author 闵大为 
 * @date 2015年7月18日
 * @Description
 * 题目描述：</br>
 * 计算数组元素除了自己的其余元素的积.</br>
 * </br>
 * 解题思路：</br>
 * 遍历一遍计算所有元素的积，然后除以每个元素，注意考虑元素0.</br>
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int zeroNum = 0;
		for(int num:nums){
			if(num==0)
				zeroNum++;
			else
				product*=num;
		}
		for(int i =0 ;i<nums.length;++i){
			int zero_n = zeroNum;
			if(nums[i]==0)
				zero_n--;
			if(zero_n>0)
				nums[i]=0;
			else{
				if(nums[i]==0)
					nums[i]=product;
				else
					nums[i]=product/nums[i];
			}
		}
        return nums;
    }
	
	@Test
	public void main(){
		int[] nums={1,2,3,0};
		int[] answers={0,0,0,6};
		int[] results = productExceptSelf(nums);
		
		for(int i=0;i<answers.length;++i)
			assertEquals(answers[i], results[i]);
		System.out.println("OK!");
	}
	
}
