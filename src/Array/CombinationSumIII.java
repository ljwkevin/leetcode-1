package Array;

import java.util.ArrayList;
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
public class CombinationSumIII {
	  public void go(List<List<Integer>> result,List<Integer> visited,int[] candidates,int idx,int cs, int target){
		   if(target==0){
			   if(cs==0&&!result.contains(visited))
				   result.add(visited);
			   return;
		   }
		   if(cs<0)
			   return;
		   if(idx>=candidates.length||candidates[idx]>target)
			   return;
		   List<Integer> visit1 = new ArrayList<Integer>();
		   List<Integer> visit2 = new ArrayList<Integer>();
		   for(int i = 0;i<visited.size();++i){
			   visit1.add(visited.get(i));
			   visit2.add(visited.get(i));
		   }
		   visit2.add(candidates[idx]);
		   go(result, visit2,candidates,idx+1,cs-1,target-candidates[idx]);
		   go(result, visit1,candidates,idx+1,cs,target);
		  
	   }
	
	   public List<List<Integer>> combinationSum(int[] candidates,int cs, int target) {
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   List<Integer> visited = new ArrayList<Integer>();
		   go(result,visited,candidates, 0,cs, target);
		   return result;
	   }
	   
	   public List<List<Integer>> combinationSum3(int k, int n) {
		   int[] candidates = {1,2,3,4,5,6,7,8,9};
		   return combinationSum(candidates,k,n);
	   }
	   
	   @Test
	   public void main(){
		   List<List<Integer>> result = combinationSum3(3,9);
		   for(List<Integer> ls:result){
			   for(int num :ls)
				   System.out.print(num+" ");
			   System.out.println();
		   }
	   }
}
