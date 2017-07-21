package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月19日
 * @Description
 * 题目描述：</br>
 * 求三个数的和为0</br>
 * </br>
 * 解题思路：</br>
 * 先排序，然后使用二分查找,用HashSet存储</br>
 */
public class ThreeSum {
	class Node{
		int i;
		int j;
		int k;
		public Node(int i, int j, int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}
			
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return 3*i+5*j+7*k;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Node node = (Node)obj;
			return i==node.i&&j==node.j&&k==node.k;
		}
		
		@Override
		public String toString() {
			return "Node [i=" + i + ", j=" + j + ", k=" + k + "]";
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 Set<Node> set = new HashSet<>();
		 Arrays.sort(nums);
		 for(int i=0;i<nums.length-2;++i)
			 for(int j=i+1;j<nums.length-1;++j){
				 int needNum = -(nums[i]+nums[j]);
				 if(needNum<nums[j+1]||needNum>nums[nums.length-1])
					 continue;
				 int k = Arrays.binarySearch(nums,j+1,nums.length, needNum);
				 if(k<0)
					 continue;
				 Node node = new Node(nums[i], nums[j], nums[k]);
				 set.add(node);
			 }
		 for(Node node :set){
			 List<Integer> ls = new ArrayList<Integer>();
			 ls.add(node.i);
			 ls.add(node.j);
			 ls.add(node.k);
			 result.add(ls);
		 }
		 return result;
	 }
	 
	 
	 @Test
	 public void main(){
		 int[] nums2 = {-1,0,1,2,-1,-4};
		 int[] nums1 = {2,-8,8,6,-14,-12,11,-10,13,14,7,3,10,-13,3,-15,7,3,-11,-8,4,5,9,11,7,1,3,13,14,-13,3,-6,-6,-12,-15,-12,-9,3,-15,-11,-6,-1,0,11,2,-12,3,-6,6,0,-6,-12,-10,-12,6,5,-4,-5,-5,-4,-11,13,5,-2,-13,-3,-7,-15,8,-15,12,-13,0,-3,6,9,-8,-6,10,5,9,-11,0,7,-15,-8,-3,-4,-6,7,7,-2,-2,-11,3,0,-6,12,0,-13,4,-3,11,-11,1,2,13,8,4,9,-1,-2,5,14,12,5,13,-6,-13,-8,9,1,5,-8,-2,-6,-1};
		 int[] nums0 ={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		 
		 int[] nums = {0,0,0};
		 List<List<Integer>> reuslt = threeSum(nums);
		 System.out.println(reuslt.size());
		 for(List<Integer> ls:reuslt){
			 for(Integer i :ls)
				 System.out.print(i+" ");
			 System.out.println();
		 }
		 
	 }
	 
}
