package Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @ClassName: SpiralMatrix 
 * @author 闵大为
 * @date 2015年6月24日
 * @Description
 * 解题思路
 * <li>先按原来的方向来，然后再按右，下，左，上
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ls = new ArrayList<Integer>();
        int row = matrix.length;
        if(row==0)
        	return ls;
        int col = matrix[0].length;
        int dir[][]={
        		{0,1},
        		{1,0},
        		{0,-1},
        		{-1,0}	
        };
        int visited[][] = new int[row][col];
        int r0=0;
        int c0=0;
        ls.add(matrix[r0][c0]);
        visited[r0][c0]=1;
        
        int oldDir = 0;
        for(int i=0;i<4;++i){
        	int newDir = (oldDir+i)%4;
        	int r = r0+dir[newDir][0];
        	int c = c0+dir[newDir][1];
        	if(r>=0&&r<row&&c>=0&&c<col){
        		if(visited[r][c]==0){
        			ls.add(matrix[r][c]);
        			r0=r;
        			c0=c;
        			visited[r0][c0]=1;
        			oldDir=newDir;
        			i=-1;
        		}
        	}
        }
        return ls;
        
    }
	
	@Test
	public void main(){
		int matrix[][] =
			{
			 { 1, 2, 3 ,7},
			 { 4, 5, 6 ,8},
		     { 7, 8, 9 ,10}
			};
		List<Integer> ls = spiralOrder(matrix);
		for(Integer i:ls){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
