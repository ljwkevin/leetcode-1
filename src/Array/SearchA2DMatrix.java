package Array;

import org.junit.Test;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix,int target){
		for(int i=0;i<matrix.length;++i){
			if(matrix[i][0]>target)
				return false;
			if(matrix[i][matrix[i].length-1]>=target)
				for(int j=0;j<matrix[i].length;++j)
					if(matrix[i][j]==target)
						return true;
		}
		return false;
	}
	
	@Test
	public void main(){
		int[][] matrix = {
							{1,3,5,7},
							{10,11,16,20},
							{23,30,34,50}
						 };
		int target = 50;
		System.out.println(searchMatrix(matrix, target));
	}
	
}
