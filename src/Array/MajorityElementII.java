package Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 样例 
 * @author 闵大为
 * @date 2015年7月10日
 * @Description
 * 题目描述：</br>
 * Given an integer array of size n, 
 * find all elements that appear more than n/3 times. 
 * The algorithm should run in linear time and in O(1) space.
 * </br>
 * 解题思路：最多只有两个数
 * 1 源代码参考 http://blog.csdn.net/brucehb/article/details/46689209 </br>
 * 2 注意具体判断步骤
 */
public class MajorityElementII {
	 public List<Integer> majorityElement(int[] nums) {
	     	List<Integer> ls = new ArrayList<Integer>();
	     	if(nums.length==0)
	     		return ls;
	     	
	     	int nums1 = -1;
	     	int n1 = 0;
	     	int nums2 = -1;
	     	int n2 = 0;
	     	
	     	for(int num:nums){
	     	//	System.out.println(nums1+" "+n1);
	     	//	System.out.println(nums2+" "+n2);
	     	//	System.out.println(num);	
	     		if(n1==0||nums1==num){
	     			nums1=num;
	     			n1++;
	     		}else if(n2==0||nums2==num){
	     			nums2=num;
	     			n2++;
	     		}else{
	     			n1--;
	     			n2--;
	     		}
		     	
	     	}
	     	
	     	int count1 = 0;
	     	int count2 = 0;
	     	for(int num:nums){
	     		if(num==nums1)
	     			count1++;
	     		if(num==nums2)
	     			count2++;
	     	}
	     	
	     	int count  = nums.length/3;
	     	if(count1>count)
	     		ls.add(nums1);
	     	if(count2>count&&nums2!=nums1)
	     		ls.add(nums2);
	     	return ls;
	 }
	 
	 @Test
	 public void main(){
		 int nums[] ={2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
		 majorityElement(nums).forEach(e->{System.out.println(e);});
	 }
}
