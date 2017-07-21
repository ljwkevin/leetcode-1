package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月20日
 * @Description
 * 题目描述：</br>
 * 求合</br>
 * </br>
 * 解题思路：</br>
 * 递归，对于每个数：用或者不用。注意先排序。</br>
 */
public class CombinationSum {
	   public void go(List<List<Integer>> result,List<Integer> visited,int[] candidates,int idx, int target){
		   if(target==0){
			   result.add(visited);
			   return;
		   }
		   if(idx>=candidates.length||candidates[idx]>target)
			   return;
		   List<Integer> visit1 = new ArrayList<Integer>();
		   List<Integer> visit2 = new ArrayList<Integer>();
		   for(int i = 0;i<visited.size();++i){
			   visit1.add(visited.get(i));
			   visit2.add(visited.get(i));
		   }
		   visit2.add(candidates[idx]);
		   go(result, visit1,candidates,idx+1,target);
		   go(result, visit2,candidates,idx,target-candidates[idx]);
	   }
	
	   public List<List<Integer>> combinationSum(int[] candidates, int target) {
		   Arrays.sort(candidates);
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   List<Integer> visited = new ArrayList<Integer>();
		   go(result,visited,candidates, 0, target);
		   return result;
	   }
	   
	   @Test
	   public void main(){
		   int[] candidates = {8,7,4,3};
		   int target =11;
		   List<List<Integer>> result = combinationSum(candidates, target);
		   for(List<Integer> ls:result){
			   for(int num :ls)
				   System.out.print(num+" ");
			   System.out.println();
		   }
	   }
}
