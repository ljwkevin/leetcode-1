package Array;

import org.junit.Test;

/**
 * @ClassName UniquePaths 
 * @author 闵大为
 * @date 2015年6月21日
 * @Description
 * 解题思路:<br/>
 * <li>从目的地开始，往前推，采用动态规划思想
 * <li>注意只有一个1的时候输出为0
 */
public class UniquePathsII {
	@Test
	public void main(){
		int[][] obstacleGrid = {
		  {0}
		};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int m = obstacleGrid.length;
		 int n = obstacleGrid[0].length;
		 int maps[][] = new int[m][n];
		 if(obstacleGrid[m-1][n-1]==0)
			 maps[m-1][n-1]=1;
		// fill the last row
		for(int col=n-2;col>=0;--col){
			if(obstacleGrid[m-1][col]==0) // can walk
				maps[m-1][col]=maps[m-1][col+1];
		}
		// fill the last col
		for(int row=m-2;row>=0;--row){
			if(obstacleGrid[row][n-1]==0) // can walk
				maps[row][n-1]=maps[row+1][n-1];
		}
		// fill other place
		for(int row = m-2;row>=0;--row)
			for(int col = n-2;col>=0;--col){
				if(obstacleGrid[row][col]==0)	  // can walk
					maps[row][col]=maps[row+1][col]+maps[row][col+1];
			}
		return maps[0][0];
	}
}
