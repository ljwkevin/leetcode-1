package Array;

import org.junit.Test;
/**
 * @ClassName: SearchForARange 
 * @author 闵大为
 * @date 2015年6月28日
 * @Description: 
 * 解题思路：
 * <li>二分查找，然后由中间向两边扩散 
 */
public class SearchForARange {
	 public int[] searchRange(int[] nums, int target) {
	        int[] idx = {-1,-1};
	        int left = 0;
	        int right = nums.length-1;
	        int idx0 =-1;
	        while(left<=right){
	        	int mid =(left+right)>>1;
	        	if(target==nums[mid]){
	        		idx0=mid;
	        		break;
	        	}else if(target<nums[mid])
	        		right=mid-1;
	        	else
	        		left=mid+1;
	        }
	        if(idx0!=-1){
	        	left=right=idx0;	
	        	while(left-1>=0&&nums[left-1]==target)
	        		left--;
	        	while(right+1<nums.length&&nums[right+1]==target)
	        		right++;
	        	idx[0]=left;
	        	idx[1]=right;
	        }
	        return idx;
	 }
	 
	 @Test
	 public void main(){
		 int[] nums ={1,1,2};
		 int target = 1;
		 int[] idx = searchRange(nums, target);
		 System.out.printf("%d %d",idx[0],idx[1]);
	 }
}
