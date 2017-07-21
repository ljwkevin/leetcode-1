package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月20日
 * @Description
 * 题目描述：</br>
 * 求四个数的和为target</br>
 * </br>
 * 解题思路：</br>
 * 先排序，然后使用二分查找,用HashSet存储</br>
 */
public class FourSum {
		class Node{
			int i;
			int j;
			int k;
			int q;
			public Node(int i, int j, int k,int q) {
				super();
				this.i = i;
				this.j = j;
				this.k = k;
				this.q = q;
			}
				
			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return 3*i+5*j+7*k+11*q;
			}
			
			@Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				Node node = (Node)obj;
				return i==node.i&&j==node.j&&k==node.k&&q==node.q;
			}
			
			@Override
			public String toString() {
				return "Node [i=" + i + ", j=" + j + ", k=" + k + ", q=" + q + "]";
			}
		}
		
	 	public List<List<Integer>> fourSum(int[] nums, int target)  {
			 List<List<Integer>> result = new ArrayList<List<Integer>>();
			 Set<Node> set = new HashSet<>();
			 Arrays.sort(nums);
			 for(int i=0;i<nums.length-3;++i)
				 for(int j=i+1;j<nums.length-2;++j)
					 for(int k=j+1;k<nums.length-1;++k){
						 int needNum = target-(nums[i]+nums[j]+nums[k]);
						 if(needNum<nums[k+1]||needNum>nums[nums.length-1])
							 continue;
						 int q = Arrays.binarySearch(nums,k+1,nums.length, needNum);
						 if(q<0)
							 continue;
						 Node node = new Node(nums[i], nums[j], nums[k],nums[q]);
						 set.add(node);
					 }
			 for(Node node :set){
				 List<Integer> ls = new ArrayList<Integer>();
				 ls.add(node.i);
				 ls.add(node.j);
				 ls.add(node.k);
				 ls.add(node.q);
				 result.add(ls);
			 }
			 return result;
		 }
		 
		 @Test
		 public void main(){
			 int[] nums = {1,0,-1,0,-2,2};
			 int target = 0;
			 List<List<Integer>> reuslt = fourSum(nums,target);
			 System.out.println(reuslt.size());
			 for(List<Integer> ls:reuslt){
				 for(Integer i :ls)
					 System.out.print(i+" ");
				 System.out.println();
			 }
		 }
	 
}
