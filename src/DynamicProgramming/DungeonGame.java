package DynamicProgramming;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月31日
 * @Description
 * 题目参考：https://leetcode.com/problems/dungeon-game/ <br/>
 * 思路：从后往前，动态规划. <br/>
 */
public class DungeonGame {

	void print(int[][] nums ,String str){
		System.out.println("----------------"+str+"----------------");
		for(int[] num :nums){
			for(int n :num){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println("----------------"+"---"+"----------------");
	}
	
	int minHp = Integer.MAX_VALUE;

	void go(int r, int c, int row, int col, int[][] hp, int[][] mhp,
			int[][] dungeon) {
		if(c+1<col)
			 c=c+1;
		else{
			if(r+1<row){
				r=r+1;
				c=1;
			}else{
				if (mhp[r][c] < minHp)
					minHp = mhp[r][c];
				return;
			}
		}
		
		int hp0 = hp[r][c];
		int mhp0 = mhp[r][c];
		
		int hp_t1 = hp[r][c - 1] + dungeon[r][c];
		int hp1 = hp_t1 > 0 ? hp_t1 : 1;
		int mhp1 = mhp[r][c - 1] + (hp1 - hp_t1);
		
		int hp_t2 = hp[r - 1][c] + dungeon[r][c];
		int hp2 = hp_t2 > 0 ? hp_t2 : 1;
		int mhp2 = mhp[r - 1][c] + (hp2 - hp_t2);
		boolean isFirst = false;
		boolean isSecond = false;
		
		if(mhp1<mhp2){
			isFirst =true;
			if(hp_t2+mhp2>hp_t1+mhp1)
				isSecond = true;
		}else if(mhp2<mhp1){
			isSecond =true;	
			if(hp_t1+mhp1>hp_t2+mhp2)
				isFirst = true;
		}else{
			if(hp_t1>hp_t2)
				isFirst = true;
			else
				isSecond = true;
		}
		
		
		if(mhp1>=minHp)
			isFirst = false;
		if(mhp2>=minHp)
			isSecond = false;

		if(isFirst&&!isSecond){
			hp[r][c] = hp1; 
			mhp[r][c] = mhp1;
			go(r, c, row, col, hp, mhp, dungeon);
			hp[r][c] = hp0; 
			mhp[r][c] = mhp0;
		}else if(isSecond&&!isFirst){
			hp[r][c] = hp2; 
			mhp[r][c] = mhp2;
			go(r, c, row, col, hp, mhp, dungeon);
			hp[r][c] = hp0; 
			mhp[r][c] = mhp0;
		}else if(isSecond&&isFirst){
			if(mhp1<mhp2){
				hp[r][c] = hp1; 
				mhp[r][c] = mhp1;
				go(r, c, row, col, hp, mhp, dungeon);
				hp[r][c] = hp0; 
				mhp[r][c] = mhp0;
			}else{
				hp[r][c] = hp2; 
				mhp[r][c] = mhp2;
				go(r, c, row, col, hp, mhp, dungeon);
			}
		
		}	
	}
	
	
	public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length;
        if(row==0)
        	return 0;
        int col = dungeon[0].length;
        if(col==0)
        	return 0;
        
        int[][] hp = new int[row][col];  // 当前单元生命值
        int[][] mhp = new int[row][col]; // 到当前单元的起点最小生命值
       
        if(dungeon[0][0]>0){
        	hp[0][0] = dungeon[0][0]+1;
        	mhp[0][0] = 1;
        }else{
        	hp[0][0] = 1;
        	mhp[0][0] = 1-dungeon[0][0];
        }
        
        for(int i=1;i<col;++i){
        	int hp_t = hp[0][i-1]+dungeon[0][i];
        	hp[0][i] = hp_t>0?hp_t:1;
        	mhp[0][i] =  mhp[0][i-1] + (hp[0][i]-hp_t);     			
        }
       
        
        for(int i=1;i<row;++i){
        	int hp_t = hp[i-1][0]+dungeon[i][0];
        	hp[i][0] = hp_t>0?hp_t:1;
        	mhp[i][0] =  mhp[i-1][0] + (hp[i][0]-hp_t);     	
        }
        
        if(row==1||col==1)
        	return mhp[row-1][col-1];
        else{
        	go(1,0,row, col, hp, mhp, dungeon);
        	return minHp;
        }
    }
	
	

	
	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if(row==0)
        	return 0;
        int col = dungeon[0].length;
        if(col==0)
        	return 0;
        
        int[][] minHp = new int[row+1][col+1];  // 到当前所需最小的生命值
     
        for(int i=0;i<col;++i)
        	minHp[row][i]=Integer.MAX_VALUE;
        for(int i=0;i<row;++i)
        	minHp[i][col]=Integer.MAX_VALUE;
        
        for(int r=row-1;r>=0;--r){
        	for(int c=col-1;c>=0;--c){
        		if(r==row-1&&c==col-1){
        			if(dungeon[r][c]>0)
        				minHp[r][c] = 1;
        			else
        				minHp[r][c] = 1-dungeon[r][c];
        		}else{
        			int minhp = Math.min(minHp[r+1][c], minHp[r][c+1]);
        			int thp = minhp-dungeon[r][c];
        			minHp[r][c]=thp>0?thp:1;
        		}
        			
        	}
        }
        return minHp[0][0];
	}
	
	@Test 
	public void main(){
		
		int[][] dungeon4 = {
				{1,-3,3},
				{0,-2,0},
				{-3,-3,-3}
		}; //3
		
		int[][] dungeon3 ={
				{100}
		};  //1
		int[][] dungeon2 ={
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
		}; //7
		
		
		
		int[][] dungeon ={
		 {0,-74,-47,-20,-23,-39,-48},
		 {37,-30,37,-65,-82,28,-27},
		 {-76,-33,7,42,3,49,-93},
		 {37,-41,35,-16,-96,-56,38},
		 {-52,19,-37,14,-65,-42,9},
		 {5,-26,-30,-65,11,5,16},
		 {-60,9,36,-36,41,-47,-86},
		 {-22,19,-5,-41,-8,-96,-95}
		};
		System.out.println(calculateMinimumHP(dungeon2));
	}
}
