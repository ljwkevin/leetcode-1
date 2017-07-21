package Array;

import org.junit.Test;

/** 
 * @author 闵大为
 * @date 2015年6月25日
 * @Description
 * 解题思路：
 * <li>从前往后遍历，对于i个数，考虑前i-1个中最小的，和加入i最小的
 */
public class MinimumSizeSubarraySum {
	 public int minSubArrayLen(int s, int[] nums) {
		 if(nums.length==0)
			 return 0;
		 if(nums[0]>=s)
	    	 return 1;
		 int[] sums = new int[nums.length];
	     int minLen = 0;
	     sums[0]=nums[0];  
	     for(int i=1;i<nums.length;++i){
	    	if(minLen==1)
	    		return minLen;
	    	sums[i]=sums[i-1]+nums[i];
	    	if(minLen==0){ // if sum not enough
	    		if(sums[i]>=s){
	    			minLen=i+1;
	    			for(int j=i-1;j>=0;--j){
	    				if(sums[i]-sums[j]>=s){
	    					minLen=i-j;
	    					break;
	    				}		
	    			}
	    		}
	    	}else{
	    		// consider nums[i]
	    		if(sums[i]-sums[i-minLen+1]>=s){ // if need deal 
	    			for(int j=i-1;j>=i-minLen+1;--j){
	    				if(sums[i]-sums[j]>=s)
	    					minLen=i-j;
	    			}
	    		}
	    	}
	    	
	     }
		 return minLen;
	 }
	 
	 public int minSubArrayLen2(int s, int[] nums) {
		 if(nums.length==0)
			 return 0;
		 int start = 0;
		 int end = 0;
		 int minLen = Integer.MAX_VALUE;
		 int sum = 0;
		 while(start<nums.length&&end<nums.length){
			 while(sum<s&&end<nums.length){
				sum+=nums[end++];
			 }
			 while(sum>=s && start<=end) {  
				 minLen = Math.min(minLen,end-start);  
				 sum -= nums[start++];  
	         }  
		 }
		 return minLen;
	 }
	 
	 
	 @Test
	 public void main(){
		 int[] nums = {1,2,3,4,5};
		 long t1 =System.nanoTime()/1000;
		 int r1 = minSubArrayLen(11, nums);
		 long t2 =System.nanoTime()/1000;
		 int r2 = minSubArrayLen2(11, nums);
		 long t3 =System.nanoTime()/1000;
		 
		 System.out.println(r1+" "+r2+" "+(t2-t1)+" "+(t3-t2));
	 }
}