package Array;

import org.junit.Test;
/**
 * @ClassName: SpiralMatrix 
 * @author 闵大为
 * @date 2015年6月24日
 * @Description
 * 解题思路
 * <li>先按原来的方向来，然后再按右，下，左，上
 */
public class SpiralMatrixII {
	 public int[][] generateMatrix(int n) {
	        int[][] m = new int[n][n];
	        int dir[][]={
	        		{0,1},
	        		{1,0},
	        		{0,-1},
	        		{-1,0}	
	        };
	        int r0=0;
	        int c0=-1;
	        int oldDir = 0;
	        int value =1;
	        
	        for(int i=0;i<4;++i){
	        	int newDir = (oldDir+i)%4;
	        	int r = r0+dir[newDir][0];
	        	int c = c0+dir[newDir][1];
	        	if(r>=0&&r<n&&c>=0&&c<n){
	        		if(m[r][c]==0){
	        			r0=r;
	        			c0=c;
	        			m[r0][c0]=value++;
	        			oldDir=newDir;
	        			i=-1;
	        		}
	        	}
	        }	 
	        return m;
	 }
	 
	 @Test 
	 public void main(){
		 int[][] m = generateMatrix(4);
		 for(int i=0;i<m.length;++i){
			 for(int j=0;j<m[0].length;++j)
				 System.out.print(m[i][j]+" ");
			 System.out.println();
		 }
	 }
}
