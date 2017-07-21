package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
/**
 * @ClassName TwoSum 
 * @author 闵大为
 * @date 2015年6月21日
 * @method
 * 从前往后遍历，求出需要找的，然后查找
 */
public class TwoSum {
		
	
	public int[] twoSum(int[] nums, int target) {
		List<Integer> haveNums = new ArrayList<>();
		List<Integer> needNums = new ArrayList<>();
		//int[] idx ={-1,-1};
		for(int i=0;i<nums.length;++i){
			int idx = needNums.indexOf(new Integer(nums[i]));
			if(idx!=-1)
				return new int[]{idx+1,i+1};
			
			int needNum = target - nums[i];
			idx = haveNums.indexOf(new Integer(needNum));
			if(idx!=-1)
				return new int[]{idx+1,i+1};
			
			haveNums.add(new Integer(nums[i]));
			needNums.add(new Integer(needNum));
			
		}
		return null;
	}
	
	@Test
	public void  main(){
		int[] numbers={2, 7, 11, 15,12,23};
		int target=23;
		long t1 = System.nanoTime()/1000;
		int[] result = twoSum(numbers, target);
		long t2 = System.nanoTime()/1000;
		System.out.println(t2-t1+" ms");
		System.out.println(result[0]+" "+result[1]);
	}
	
	
}
