package Array;

import org.junit.Test;
import static org.junit.Assert.*;
/** 
 * @author �ɴ�Ϊ 
 * @date 2015��7��18��
 * @Description
 * ��Ŀ������</br>
 * ��������Ԫ�س����Լ�������Ԫ�صĻ�.</br>
 * </br>
 * ����˼·��</br>
 * ����һ���������Ԫ�صĻ���Ȼ�����ÿ��Ԫ�أ�ע�⿼��Ԫ��0.</br>
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
