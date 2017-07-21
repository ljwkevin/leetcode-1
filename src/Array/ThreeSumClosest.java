package Array;

import java.util.Arrays;
import org.junit.Test;

/** 
 * @author �ɴ�Ϊ 
 * @date 2015��7��20��
 * @Description
 * ���������ĺͽӽ�һ����</br>
 * </br>
 * ����˼·��</br>
 * ������Ȼ��ʹ�ö��ֲ���,�ȽϽӽ���ֵ</br>
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
