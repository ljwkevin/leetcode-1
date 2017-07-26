package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** 
 * @author 闵大为 
 * @date 2015年7月18日
 * @Description
 * 题目描述：</br>
 * 求解最大利润，可以多天买入卖出。</br>
 * </br>
 * 解题思路：</br>
 * 1 模拟交换.</br>
 * 2 只要后项比前项大，这部分值就一定可以变为利润.参考：http://www.tuicool.com/articles/NnAnYz </br>
 */
public class BestTimeToBuyAndSellStockII {
//	 public int maxProfit(int[] prices) {
//	        int max = 0;
//	        int buyPrice = -1;
//	        int sellPrice = -1;
//	        for(int i = 0;i<prices.length;++i){
//	        	if(buyPrice == -1){
//	        		buyPrice = prices[i];
//	        	}else if(sellPrice == -1){
//	        		if(prices[i]>buyPrice)
//	        			sellPrice = prices[i];
//	        		else
//	        			buyPrice = prices[i];
//	        	}else{
//	        		if(prices[i]>=sellPrice){
//	        			sellPrice=prices[i];
//	        		}else{
//	        			max += sellPrice - buyPrice;
//	        			buyPrice = prices[i];
//	        			sellPrice = -1;
//	        		}
//	        	}
//	        }
//	        if(sellPrice!=-1)
//	        	max+=(sellPrice-buyPrice);
//	        return max;
//	  }
	 
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1){
			return 0;
		}
		
		int total = 0;
	    for (int i=0; i< prices.length-1; i++) {
	        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
	    }
	    
	    return total;
	}
	
	 @Test
	 public void main(){
		 int[] prices = {2,3,10,2,3,5};
		// int[] prices2 = {2,1};
		 assertEquals(11, maxProfit(prices));
		 System.out.println("OK!");
	 }

	
}
