package Array;

import org.junit.Test;

/**
 * @ClassName UniquePaths 
 * @author �ɴ�Ϊ
 * @date 2015��6��21��
 * @Description
 * ����˼·:<br/>
 * <li>��Ŀ�ĵؿ�ʼ����ǰ�ƣ����ö�̬�滮˼��
 */
public class UniquePaths {
	@Test
	public void main(){
		int m=2;
		int n=3;
		System.out.println(cal(m, n));
	}
	public int cal(int m,int n){
		int maps[][] = new int[m][n];
		// fill the last row
		for(int col=0;col<n;++col)
			maps[m-1][col]=1;
		// fill the last col
		for(int row=0;row<m;++row)
			maps[row][n-1]=1;
		// fill other place
		for(int row = m-2;row>=0;--row)
			for(int col = n-2;col>=0;--col)
				maps[row][col]=maps[row+1][col]+maps[row][col+1];
		return maps[0][0];
	}
}
