package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** 
 * @author �ɴ�Ϊ 
 * @date 2015��7��18��
 * @Description
 * ��Ŀ������</br>
 * ���������󣬿��Զ�������������</br>
 * </br>
 * ����˼·��</br>
 * 1 ģ�⽻��.</br>
 * 2 ֻҪ�����ǰ����ⲿ��ֵ��һ�����Ա�Ϊ����.�ο���http://www.tuicool.com/articles/NnAnYz </br>
 */
public class BestTimeToBuyAndSellStockII {
	 public int maxProfit(int[] prices) {
	        int max = 0;
	        int buyPrice = -1;
	        int sellPrice = -1;
	        for(int i = 0;i<prices.length;++i){
	        	if(buyPrice == -1){
	        		buyPrice = prices[i];
	        	}else if(sellPrice == -1){
	        		if(prices[i]>buyPrice)
	        			sellPrice = prices[i];
	        		else
	        			buyPrice = prices[i];
	        	}else{
	        		if(prices[i]>=sellPrice){
	        			sellPrice=prices[i];
	        		}else{
	        			max += sellPrice - buyPrice;
	        			buyPrice = prices[i];
	        			sellPrice = -1;
	        		}
	        	}
	        }
	        if(sellPrice!=-1)
	        	max+=(sellPrice-buyPrice);
	        return max;
	  }
	 
	 @Test
	 public void main(){
		 int[] prices = {2,3,10,2,3,5};
		 int[] prices2 = {2,1};
		 assertEquals(0, maxProfit(prices2));
		 System.out.println("OK!");
	 }
}
