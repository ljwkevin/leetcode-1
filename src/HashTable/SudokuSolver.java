package HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月21日
 * @Description
 * 数独游戏，递归遍历即可</br>
 */
public class SudokuSolver {
	class Node{
		int i;
		int j;
		public Node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	Node nextPos(int row,int col,Node node){
		if(node.j+1<col){
			node.j+=1;
			return node;
		}
		node.i+=1;
		node.j=0;
		return node;
	}
	
	List<Integer> getNum(int[][] board,int r,int c){
		List<Integer> integers = new ArrayList<Integer>();
		for(int i=1;i<=9;++i)
			integers.add(i);
		
		int r0 = r/3*3;
		int c0 = c/3*3;
		for(int i=r0;i<r0+3;++i)
			for(int j=c0;j<c0+3;++j){
				if(integers.contains(board[i][j]))
					integers.remove(new Integer(board[i][j]));
			}
		
		for(int i=0;i<board.length;++i)
			if(integers.contains(board[i][c]))
				integers.remove(new Integer(board[i][c]));
		
		for(int i=0;i<board[0].length;++i)
			if(integers.contains(board[r][i]))
				integers.remove(new Integer(board[r][i]));
		
		return integers;
	}
	
	Boolean isFound = false;
	
	void go(int[][] board,int i,int j){
		
		if(isFound)
			return;
	
		int row = board.length;
		int col = board[0].length;
		
		if(board[i][j]==0){
			List<Integer> nums = getNum(board,i,j);

			for(int num:nums){
				board[i][j]=num;
				if(i==row-1&&j==col-1){
					isFound =true;
					return;
				}
				Node node = nextPos(row, col, new Node(i, j));
				go(board,node.i,node.j);
				if(isFound){
					board[i][j] = num;
					return;
				}
				board[i][j]=0;
			}
			
		}else{
			Node node = nextPos(row, col, new Node(i, j));
			if(node.i>=row){
				isFound = true;
				return;
			}
			go(board,node.i,node.j);
		}
	}
	
	 public void solveSudoku(char[][] board) {
		 	int[][] map = new int[board.length][board[0].length];
		 	
		 	for(int i=0;i<board.length;++i)
		 		for(int j=0;j<board[0].length;++j){
		 			if(board[i][j]!='.')
		 				map[i][j]=board[i][j]-'0';
		 		}
		 	
		 	go(map,0,0);
		 	
		 	for(int i=0;i<board.length;++i)
		 		for(int j=0;j<board[0].length;++j){
		 			if(board[i][j]=='.')
		 				board[i][j]=(char)('0'+map[i][j]);
		 		}
		 	
	 }
	 
	 void myPrint( char[][] board){
		 for(char[] chs :board){
			 for(char ch:chs){
				 System.out.print(ch+" ");
			 }
			 System.out.println();
		 }
		 System.out.println();
	 }
	 
	 void myPrint( int[][] board){
		 for(int[] chs :board){
			 for(int ch:chs){
				 System.out.print(ch+" ");
			 }
			 System.out.println();
		 }
		 System.out.println();
	 }
	 
	 @Test
	 public void main(){
		 char[][] board ={
				 {'5','3','.','.','7','.','.','.','.'},
				 {'6','.','.','1','9','5','.','.','.'},
				 {'.','9','8','.','.','.','.','6','.'},
				 {'8','.','.','.','6','.','.','.','3'},
				 {'4','.','.','8','.','3','.','.','1'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','6','.','.','.','.','2','8','.'},
				 {'.','.','.','4','1','9','.','.','5'},
				 {'.','.','.','.','8','.','.','7','9'},
		 };
		 myPrint(board);
		 solveSudoku(board);
		 myPrint(board);
	 }
}
