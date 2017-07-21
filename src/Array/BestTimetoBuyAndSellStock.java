package Array;

import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * @author 闵大为 
 * @date 2015年7月18日
 * @Description
 * 题目描述:</br>
 * 寻找出买股票的最大收益</br>
 * </br>
 * 解题思虑：</br>
 * 分治算法</br> 
 */
public class BestTimetoBuyAndSellStock {
	
	 int getMaxCross(int[] prices,int bg,int mid,int ed){
		int lSum = 0;
		int lMaxSum = 0;
		for(int i=mid;i>=bg;--i){
			lSum+=prices[i];
			if(lSum>lMaxSum)
				lMaxSum=lSum;
		}
		
		int rSum = 0;
		int rMaxSum = 0;
		for(int i=mid+1;i<=ed;++i){
			rSum+=prices[i];
			if(rSum>rMaxSum)
				rMaxSum=rSum;
		}
		return lMaxSum+rMaxSum;
	 }

	 int getMax(int[] prices,int bg,int ed){
		 if(bg==ed)
			 return prices[bg];
		 int mid = (bg+ed)>>1;
		 int left = getMax(prices,bg,mid);
		 int middle = getMaxCross(prices,bg,mid,ed);
		 int right = getMax(prices, mid+1, ed);
		 return Math.max(Math.max(left, right), middle);
	 }
	
	 public int maxProfit(int[] prices) {
		 	if(prices.length==0)
		 		return 0;
	        for(int i = prices.length-1;i>0;i--)
	        	prices[i]-=prices[i-1]; 
	        prices[0]=0;
	        return getMax(prices,0,prices.length-1);
	 }
	 
	 @Test
	 public void main(){
		 int[] prices = {2,3,10,2,3,5};
		 assertEquals(8, maxProfit(prices));
		 System.out.println("OK!");
	 }
	 
}
