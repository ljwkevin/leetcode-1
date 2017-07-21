package Array;

import org.junit.Test;
/**
 * @ClassName: RotateImage 
 * @Description: 矩阵顺时针旋转90度
 * @author 闵大为
 * @date 2015年6月29日
 * 解题思路：
 * <li><code>r=c;c=n-1-r;</code>考虑到空间复杂度的话，需要四个旋转，而且i的遍历只要到<code>i&lt=(n-1)</code>
 */
public class RotateImage{
	public void rotate(int[][] matrix) {
	        int n = matrix.length;
	        int lf = 0;
	        int rg = n-1;
	        for(int i=0;i<=(n-1)/2;++i){
	        	for(int j=lf;j<rg;++j){
	        		int n_r;
	        		int n_c;
	        		int r =i;
	        		int c =j;
	        		int frontValue=matrix[r][c];
	        		int nowValue;
	        		for(int k=0;k<4;++k){
	        			n_r = c;
	        			n_c = n-1-r;
	        			nowValue = matrix[n_r][n_c];
	        			matrix[n_r][n_c]= frontValue;
	        			frontValue = nowValue;
	        			r= n_r;
	        			c= n_c;
	        		}
	        	}
	        	lf++;
	        	rg--;
	        	if(lf>rg)
	        		break;
	        }
	 }

	 public void printf(int[][] matrix) {
		 for(int[] i:matrix){
			 for(int j:i)
				 System.out.print(j+" ");
			 System.out.println();
		 }
	 }
	 
	 
	 @Test
	 public void main(){
		 int[][] matrix = 
			 	{
				 {1,2,3,4},
				 {5,6,7,8},
				 {9,10,11,12},
				 {13,14,15,16}
				};
		 //printf(matrix);
		 rotate(matrix);
		 printf(matrix);
	 }
}
