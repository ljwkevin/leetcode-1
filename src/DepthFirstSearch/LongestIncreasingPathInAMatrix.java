package DepthFirstSearch;

import java.util.Scanner;
/**
 * @author 闵大为
 * @data 2017年7月26日
 * @Description
 * 最长递减路径:
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/#/description
 */
public class LongestIncreasingPathInAMatrix {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] matrix = new int[m][n];
		for(int i=0;i<m;++i){
			for(int j=0;j<n;++j){
				matrix[i][j] = in.nextInt();
			}
		}
		System.out.println(longestIncreasingPath(matrix));
		in.close();
	}
	
	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] lens = new int[m][n];
		int maxLen = 0;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				maxLen = Math.max(maxLen,vis(i, j, m, n, matrix, lens));
			}
		}

		return maxLen;
	}

	private static final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int vis(int i, int j, int m, int n, int[][] map, int[][] lens) {
		int ni, nj;
		int maxLen = 1;
		int len = 0;
		for (int[] dir : dirs) {
			ni = i + dir[0];
			nj = j + dir[1];
			if (ni >= 0 && ni < m && nj >= 0 && nj < n && map[ni][nj] < map[i][j]) {
				if ((len = lens[ni][nj]) != 0) {
					maxLen = Math.max(maxLen, len + 1);
				} else {
					maxLen = Math.max(maxLen,vis(ni, nj, m, n, map, lens)+ 1);
				}
			}
		}
		lens[i][j] = maxLen;
		return maxLen;
	}
	
}
