package DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月7日
 * @Description
 * 题目参考：https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		if(numCourses==0)
			return new int[0];
		
		int[] preNum = new int[numCourses];
		List<Integer>[] arc = new List[numCourses];
		for(int i=0;i<numCourses;++i)
			arc[i]=new ArrayList<Integer>();

		for(int[] pre :prerequisites){
			arc[pre[1]].add(pre[0]);
			preNum[pre[0]]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<preNum.length;++i)
			if(preNum[i]==0)
				que.offer(i);
		int[] nums = new int[numCourses];
		int pos = 0;
		while(!que.isEmpty()){
			int idx  = que.poll();
			nums[pos++]=idx;
			for(int i :arc[idx]){
				preNum[i]--;
				if(preNum[i]==0)
					que.add(i);
			}
		}
		if(pos==numCourses)
			return nums;
		else
			return new int[0];
    }
	
	@Test
	public void main(){
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] nums = findOrder(4, prerequisites);
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();
	}
	
}
