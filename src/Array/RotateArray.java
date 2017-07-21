package Array;

import java.util.Arrays;

import org.junit.Test;
/** 
 * @author �ɴ�Ϊ
 * @date 2015��6��30��
 * @Description
 * ����˼·��
 * <li>����1 �����ڴ�ռ䣬����k�����������ƹ�ȥ
 * <li>����2 һ��һ�������ŵ�֮ǰ
 * <li>����3 AB���ã�A��B�ֱ���
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
