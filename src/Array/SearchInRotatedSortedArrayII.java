package Array;

import org.junit.Test;

public class SearchInRotatedSortedArrayII {
		 public boolean search2(int[] nums, int target) {
			 for(int i=0;i<nums.length;++i)
				 if(nums[i]==target)
					 return true;
			 return false;
		 }
		 
		 public boolean search(int[] nums, int target) {
				int left = 0;
				int right = nums.length-1;
				while(left<=right){
					int mid = (left+right)/2;
					if(nums[mid]==target)
						return true;
					if(nums[left]<nums[mid]){
						if(target<nums[mid]&&target>=nums[left])
							right = mid-1;
						else 
							left = mid+1;
					}else if(nums[left]>nums[mid]) {
						if(target>=nums[left]||target<nums[mid])
							right = mid-1;
						else
							left = mid+1;
					
					}else
						left++;
						
				}
			return false;
		 }
		 
		 
		 @Test
		 public void main(){
			 
			 int[] nums = {1,3,1,1,1};
			 
			 long t1 = System.nanoTime()/1000;
			 boolean t =search(nums, 3);
			 long t2 = System.nanoTime()/1000;
			 System.out.println((t2-t1)+"ms "+t); //292ms -1
			 
		 }
}
