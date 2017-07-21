package Array;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 样例 
 * @author 闵大为
 * @date 2015年7月10日
 * @Description
 * 题目描述：</br>
 * Given an array of size n, 
 * find the majority element. 
 * The majority element is the 
 * element that appears more 
 * than  n/2 times
 * </br>
 * 解题思路：直接计数，注意只有一个数也可能返回
 */
public class MajorityElement {
	 public int majorityElement(int[] nums) {
	       Map<Integer, Integer> map = new HashMap<>();
	       int cs = nums.length/2;
	       for(int num:nums){
	    	   if(map.containsKey(num)){
	    		   int cs0 = map.get(num);
	    		   if(cs0+1>cs)
	    			   return num;
	    		   else
	    			   map.put(num, cs0+1);
	    	   }else{
	    		   map.put(num, 1);
	    		   if(1>cs)
	    			   return num;
	    	   }
	       }
	       return -1;
	 }
	 
	 @Test 
	 public void main(){
		 int[] nums = {1};
		 System.out.println(majorityElement(nums));
	 }
}
