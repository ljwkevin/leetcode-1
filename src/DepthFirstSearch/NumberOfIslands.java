package DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月7日
 * @Description
 * 题目参考：https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

	
	public int numIslands(char[][] grid) {
		
		int gs = 0;
		int[][] dirs = {
				{0,-1},
				{0,1},
				{1,0},
				{-1,0}
		};
		for(int i=0;i<grid.length;++i){
			for(int j=0;j<grid[0].length;++j){
				if(grid[i][j]=='1'){
					gs++;
					Queue<Integer> qi = new LinkedList<Integer>();
					Queue<Integer> qj = new LinkedList<Integer>();
					qi.offer(i);
					qj.offer(j);
					grid[i][j] = '0';
					while(!qi.isEmpty()){
						int ti = qi.poll();
						int tj = qj.poll();
						for(int k=0;k<4;++k){
							int ni = ti+dirs[k][0];
							int nj = tj+dirs[k][1];
							if(ni>=0&&ni<grid.length&&nj>=0&&nj<grid[i].length){
								if(grid[ni][nj]=='1'){
									grid[ni][nj]='0';
									qi.offer(ni);
									qj.offer(nj);
								}
							}
						}
					}
				}
			}
		}
		return gs;
    }
	
	@Test
	public void main(){
		char[][] grid = {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','1','1','1','0'},
			{'0','0','0','1','1'}	
		};
		System.out.println(numIslands(grid));
	}
	
}
