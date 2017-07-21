package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月7日
 * @Description
 * 题目参考：https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

	class Node{
		int i;
		int j;
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
    public void solve(char[][] board) {
		int[][] dirs = {
				{0,-1},
				{0,1},
				{1,0},
				{-1,0}
		};
		
		List<Node> lsReset = new ArrayList<>();
		
		for(int i=0;i<board.length;++i){
			for(int j=0;j<board[0].length;++j){
				if(board[i][j]=='O'){
				
					Queue<Integer> qi = new LinkedList<Integer>();
					Queue<Integer> qj = new LinkedList<Integer>();
					qi.offer(i);
					qj.offer(j);
					board[i][j] = 'X';
					List<Node> lsNodes = new ArrayList<>();
					boolean isAdd = false;
					while(!qi.isEmpty()){
						int ti = qi.poll();
						int tj = qj.poll();
						lsNodes.add(new Node(ti, tj));
						if(ti==0||ti==board.length-1||tj==0||tj==board[0].length-1)
							isAdd = true;
						for(int k=0;k<4;++k){
							int ni = ti+dirs[k][0];
							int nj = tj+dirs[k][1];
							if(ni>=0&&ni<board.length&&nj>=0&&nj<board[i].length){
								if(board[ni][nj]=='O'){
									board[ni][nj]='X';
									qi.offer(ni);
									qj.offer(nj);
								}
							}
						}
					}
					if(isAdd)
						lsReset.addAll(lsNodes);
				}
			}
		}
		
		for(Node node :lsReset)
			board[node.i][node.j] = 'O';
		
    }
    
    void print(char[][] borad){
    	for(char[] chs : borad){
    		for(char ch : chs){
    			System.out.print(ch+" ");
    		}
    		System.out.println();
    	}
    }
    
    @Test
    public void main(){
    	char[][] board = {
    			{'X','X','X','X'},
    			{'X','O','O','X'},
    			{'X','X','O','X'},
    			{'X','O','X','X'}	
    		};
    	print(board);
    	System.out.println();
    	solve(board);
    	print(board);
       
    }
}
