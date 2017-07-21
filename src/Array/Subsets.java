package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * @ClassName: Subsets 
 * @author �ɴ�Ϊ
 * @date 2015��6��23��
 * @Description
 * ����˼·:<br/>
 * <li>����Ȼ���������dfs
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> subResult = new ArrayList<>();
		Arrays.sort(nums);
		dfs(nums,0,subResult,results);
		return results;
    }
	
	void dfs(int[] nums,int nextIdx,List<Integer> subResult,List<List<Integer>> results ){
		if(nextIdx>=nums.length){
			results.add(new ArrayList<>(subResult));
			return;
		}
		
		dfs(nums,nextIdx+1,subResult,results);
		
		subResult.add(nums[nextIdx]);
		dfs(nums,nextIdx+1,subResult,results);
		subResult.remove(subResult.size()-1);
	}
	
	@Test
	public void main(){
		int[] nums = {2,3,1,10};
		List<List<Integer>> results = subsets(nums);
		for(List<Integer> ls:results){
			System.out.print("[");
			for(Integer i:ls)
				System.out.print(i+" ");
			System.out.println("]");
		}
	}
	
}

