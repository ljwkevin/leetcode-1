package Array;

import org.junit.Test;

public class SearchInRotatedSortedArray {
	 public int search2(int[] nums, int target) {
		 for(int i=0;i<nums.length;++i)
			 if(nums[i]==target)
				 return i;
		 return -1;
		 
	 }
	 
	 public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid]==target)
				return mid;
			if(nums[left]<=nums[mid]){
				if(target<nums[mid]&&target>=nums[left])
					right = mid-1;
				else 
					left = mid+1;
			}else{
				if(target>=nums[left]||target<nums[mid])
					right = mid-1;
				else
					left = mid+1;
			
			}
				
		}
		return -1;
	 }
	 
	 
	 @Test
	 public void main(){
		 
		 int[] nums = {4,5,6,7,8,1,2,3};
		/*for(int i=0;i<5000;++i)
			 nums[i]=5000+i;
		 for(int i=5000;i<10000;++i)
			 nums[i]=i-5000;
		 */
		 long t1 = System.nanoTime()/1000;
		 int t =search(nums, 8);
		 long t2 = System.nanoTime()/1000;
		 System.out.println((t2-t1)+"ms "+t); //292ms -1
		 
	 }
}
