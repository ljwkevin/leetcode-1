package Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * @ClassName: Triangle 
 * @author 闵大为
 * @date 2015年6月21日
 * @solvingIdeas
 * <li>从下往上遍历即可
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;--i){
        	for(int j=0;j<triangle.get(i).size();++j){
        		int t1 = triangle.get(i+1).get(j);
        		int t2 = triangle.get(i+1).get(j+1);
        		triangle.get(i).set(j, triangle.get(i).get(j)+(t1>t2?t2:t1));
        	}
        }
		return triangle.get(0).get(0);
    }
	
	@Test
	public void main(){
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		int[][] nums = {
						{2},
						{3,4},
						{6,5,7},
						{4,1,8,3},
						{1,1,1,1,1}
					   };
		
		for(int i =0;i<nums.length;++i){
			List<Integer> ls = new ArrayList<>();
			for(int j=0;j<nums[i].length;++j)
				ls.add(new Integer(nums[i][j]));
			triangle.add(ls);
		}
		
		System.out.println(minimumTotal(triangle));
		
	}
}
