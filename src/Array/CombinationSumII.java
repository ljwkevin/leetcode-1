package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
/**
 * @author �ɴ�Ϊ
 * @date 2015��7��20��
 * @Description
 * ��Ŀ������</br>
 * ���</br>
 * </br>
 * ����˼·��</br>
 * �ݹ飬����ÿ�������û��߲��á�ע��������</br>
 */
public class CombinationSumII {
	   public void go(List<List<Integer>> result,List<Integer> visited,int[] candidates,int idx, int target){
		   if(target==0){
			   if(!result.contains(visited))
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
		   go(result, visit2,candidates,idx+1,target-candidates[idx]);
	   }
	
	   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		   Arrays.sort(candidates);
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   List<Integer> visited = new ArrayList<Integer>();
		   go(result,visited,candidates, 0, target);
		   return result;
	   }
	   
	   @Test
	   public void main(){
		   int[] candidates = {10,1,2,7,6,1,5};
		   int target = 8;
		   List<List<Integer>> result = combinationSum2(candidates, target);
		   for(List<Integer> ls:result){
			   for(int num :ls)
				   System.out.print(num+" ");
			   System.out.println();
		   }
	   }
}
