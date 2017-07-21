package Array;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

/** 
 * @author �ɴ�Ϊ 
 * @date 2015��7��18��
 * @Description
 * ��Ŀ������</br>
 * �ҵ��������еĺ����</br>
 * </br>
 * ����˼·:</br>
 * ��ǰ�����������Ϊ���ǺͲ������������.</br>
 */
public class BestTimeToBuyAndSellStockIII {
	 public int _maxProfit(int[] prices,int bg,int ed,int cs) {
		 	int maxProfit = 0;
	        for(int i = bg+1;i<=ed;++i){
	        	if(prices[i]<=prices[bg])
	        		bg=i;
	        	else{
	        		if(cs == 2){
	        			int sum = (prices[i]-prices[bg])+_maxProfit(prices, i+1, ed,1);
	        			if(sum>maxProfit)
	        				maxProfit = sum;
	        		}else{
	        			if(prices[i]-prices[bg]>maxProfit)
	        				maxProfit = prices[i]-prices[bg];
	        		}
	        	}
	        }
	        return maxProfit;
	  }
	 
	 public int maxProfit(int[] prices){
		 return _maxProfit(prices, 0, prices.length-1,2);
	 }
		 
		 @Test
		 public void main(){
			 int[] prices = {1,2,4,2,5,7,2,4,9,0};
			 long t1 = System.currentTimeMillis();
			 assertEquals(13, maxProfit(prices));
			 long t2 = System.currentTimeMillis();
			 System.out.println("OK!");
		 }
}
