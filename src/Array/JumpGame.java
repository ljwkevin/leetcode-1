package Array;

import org.junit.Test;
/** 
 * @author �ɴ�Ϊ
 * @date 2015��7��15��
 * @description
 * ��Ŀ������</br>
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.Each element in the array represents 
 * your maximum jump length at that position.Determine if you are able to
 * reach the last index.</br>
 * </br>
 * ����˼·��</br>
 * ֱ�Ӵ�ǰ�����ߣ���¼�ܵ�����Զ�ĵط���</br>
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if(nums.length==1)
			return true;
		int maxPos = 0;
		for(int i=0;i<nums.length-1;++i){
			if(i>maxPos)
				return false;
			if(i+nums[i]>maxPos)
				maxPos = i+nums[i];
			if(maxPos>=nums.length-1)
				return true;
		}
		return false;
	}
		
	@Test
	public void main(){
		int[][] nums = {
				{2,3,1,1,4},
				{3,2,1,0,4},
				{1,2,3},
				{5,9,3,2,1,0,2,3,3,1,0,0},
				{0}
		};
		boolean[] answers = {true,false,true,true,true};
		for(int i =0;i<nums.length;++i){
			if(answers[i]!=canJump(nums[i])){
				System.out.println("Fail at "+i);
			}
		}
		System.out.println("Test finished!");
	}
}
