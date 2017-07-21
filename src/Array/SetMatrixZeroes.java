package Array;

import org.junit.Test;

/**
 * @ClassName: SetMatrixZeroes 
 * @author 闵大为
 * @date 2015年6月25日
 * @Description
 * 解题思路：
 * <li>舍弃一行一列作为标志位，处理时标志位最后处理
 */
public class SetMatrixZeroes {
	  public void setZeroes(int[][] matrix) {
		  boolean isColZero = false;
		  boolean isRowZero = false;
		  
		  int row = matrix.length;
		  int col = matrix[0].length;
		  
		  for(int i=0;i<row;++i){
			  for(int j=0;j<col;++j){
				  if(j==0&&matrix[i][j]==0)
					  isColZero = true;
				  if(i==0&&matrix[i][j]==0)
					  isRowZero = true;
				  if(matrix[i][j]==0){
					  matrix[i][0]=0;
					  matrix[0][j]=0;
				  }
			  }
		  }
		  
		  for(int i=1;i<row;++i){
			  if(matrix[i][0]==0)
				  for(int j=1;j<col;++j)
					  matrix[i][j]=0; 
		  }
		  
		  for(int j=1;j<col;++j){
			  if(matrix[0][j]==0)
				  for(int i=1;i<row;++i)
					  matrix[i][j]=0; 
		  }
		  
		  if(isRowZero)
			  for(int i=0;i<col;++i)
				  matrix[0][i]=0;
		
		  if(isColZero)
			  for(int i=0;i<row;++i)
				  matrix[i][0]=0;
		  
	  }
	  
	  
	  @Test
	  public void main(){
		  int[][] matrix={
				  {0,0,0,5},
				  {4,3,1,4},
				  {0,1,1,4},
				  {1,2,1,3},
				  {0,0,1,1}
		  };
		  outMatrix(matrix);
		  
		  setZeroes(matrix);
		  System.out.println();
		  outMatrix(matrix);
		  
		  
	  }
	  
	  public void outMatrix( int[][] matrix){
		  for(int i=0;i<matrix.length;++i){
			  for(int j=0;j<matrix[i].length;++j)
				  System.out.print(matrix[i][j]+"　");
			  System.out.println();
		  }
	  }
}
