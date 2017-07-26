package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月18日
 * @Description
 * 题目描述：</br>
 * 找到两个序列的和最大</br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/#/discuss
 */
public class BestTimeToBuyAndSellStockIII {
//	 public int _maxProfit(int[] prices,int bg,int ed,int cs) {
//		 	int maxProfit = 0;
//	        for(int i = bg+1;i<=ed;++i){
//	        	if(prices[i]<=prices[bg])
//	        		bg=i;
//	        	else{
//	        		if(cs == 2){
//	        			int sum = (prices[i]-prices[bg])+_maxProfit(prices, i+1, ed,1);
//	        			if(sum>maxProfit)
//	        				maxProfit = sum;
//	        		}else{
//	        			if(prices[i]-prices[bg]>maxProfit)
//	        				maxProfit = prices[i]-prices[bg];
//	        		}
//	        	}
//	        }
//	        return maxProfit;
//	  }
//	 
//	 public int maxProfit(int[] prices){
//		 return _maxProfit(prices, 0, prices.length-1,2);
//	 }
	 
	 public int maxProfit(int[] prices){
		 if(prices==null||prices.length<2){
			 return 0;
		 }
		 
		 int n = prices.length;
		 
		 int[] leftMaxProfits = new int[n];
		 int minBuyMoney = prices[0];
		 for(int i=1;i<n;++i){
			 leftMaxProfits[i] = Math.max(prices[i] - minBuyMoney, leftMaxProfits[i-1]);
			 minBuyMoney = Math.min(minBuyMoney, prices[i]);
		 }
		 
		 int[] rightMaxProfits = new int[n];
		 int maxBuyMoney = prices[n-1];
		 for(int i=n-2;i>=0;--i){
			 rightMaxProfits[i] = Math.max(maxBuyMoney - prices[i], rightMaxProfits[i+1]);
			 maxBuyMoney = Math.max(maxBuyMoney, prices[i]);
		 }
		 
		 int maxProfit = 0;
		 for(int i=0;i<=n;++i){
			 if(i==0){
				 maxProfit = Math.max(maxProfit, rightMaxProfits[i]);
			 }else if(i==n){
				 maxProfit = Math.max(maxProfit, leftMaxProfits[i-1]);
			 }else{
				 maxProfit = Math.max(maxProfit, leftMaxProfits[i-1]+rightMaxProfits[i]);	
			 }
		 }
		 
		 return maxProfit;
	 }
		 
		 @Test
		 public void main(){
			 int[] prices = {1,2,4,2,5,7,2,4,9,0};
			 assertEquals(13, maxProfit(prices));
			 System.out.println("OK!");
		 }
}
