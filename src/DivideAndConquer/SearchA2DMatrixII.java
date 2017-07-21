package DivideAndConquer;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 参考： https://leetcode.com/discuss/48323/order-n-java-easy-solution <br/>
 */
public class SearchA2DMatrixII {
	boolean have(int[][] matrix,int r0,int c0,int r1,int c1, int target){
		int left = c0;
		int right = c1;
		while(left<=right){
			int mid = (left+right)>>1;
			if(matrix[r0][mid] == target)
				return true;
			else if(matrix[r0][mid]<target)
				left = mid+1;
			else
				right = mid-1;
		}
		if(left-1<c0)
			return false;
		else{
			r0+=1;
			c1 = left-1;
		}
		left = r0;
		right = r1;
		while(left<=right){
			int mid = (left+right)>>1;
			if(matrix[mid][c0] == target)
				return true;
			else if(matrix[mid][c0]<target)
				left = mid+1;
			else
				right = mid-1;
				
		}
		if(left-1<r0)
			return false;
		else{
			c0+=1;
			r1 = left-1;
		}
		
		return  have(matrix,r0,c0,r1,c1,target);
		
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
		 int row = matrix.length;
		 if(row == 0)
			 return false;
		 int col = matrix[0].length;
		 if(col==0)
			 return false;
		 return have(matrix, 0, 0, row-1, col-1, target);
	 }
	 
	 @Test
	 public void main(){
		 int[][] matrix = {
		                   {1,   4,  7, 11, 15},
		                   {2,   5,  8, 12, 19},
		                   {3,   6,  9, 16, 22},
		                   {10, 13, 14, 17, 24},
		                   {18, 21, 23, 26, 30}
		                 };
		 System.out.println(searchMatrix(matrix,30));
	 }
}
