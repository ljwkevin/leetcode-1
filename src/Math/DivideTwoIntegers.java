package Math;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 题目参考：
 * https://leetcode.com/problems/divide-two-integers/ <br/>
 * 解题参考： 
 * https://leetcode.com/discuss/48905/solution-passed-test-think-another-case-needed-2147483648
 */
public class DivideTwoIntegers {
	 
	 // 都是负数
	 int _divide(int dividend, int divisor){
		 int gs = 1;
		 int val = divisor;
		 int preVal = 0;
		 int preGs = 0;
		 while(val>dividend){
			 preVal = val;
			 preGs = gs;
			 if(dividend-val>val){
				 break;
			 }
			 val+=val;
			 gs+=gs;
		 }
		 if(val==dividend)
			 return gs;
		 else{
			 if(preGs==0)
				 return 0;
			 else{
				 return preGs+_divide(dividend-preVal,divisor);	 
			 }
		 }
	 }
	 public int divide(int dividend, int divisor) {
		 if(divisor == 0)
			 return Integer.MAX_VALUE;
		 if(dividend == 0)
			 return 0;
		 boolean isPositive = true;
		 
		 if(divisor==1)
			 return dividend;
		 if(divisor==-1){
			if(dividend==Integer.MIN_VALUE)
				return Integer.MAX_VALUE;
			 return - dividend;
		 }
		 if(divisor==Integer.MIN_VALUE){
			 if(dividend==Integer.MIN_VALUE)
				 return 1;
			 else
				 return 0;
		 }

		 if(dividend>0){
			 dividend = -dividend;
			 isPositive = !isPositive;
		 }
		 if(divisor>0){
			 divisor = -divisor;
			 isPositive = !isPositive;
		 }
		 return isPositive?_divide(dividend, divisor):-_divide(dividend, divisor);
	 }
	 
	 @Test
	 public void main(){
		// System.out.println(1100540749/1090366779);
		System.out.println(divide(2, 4));
		 System.out.println(divide(2, -1));
		 System.out.println(divide(-2, -1));
		 System.out.println(divide(-2, 1));
		 System.out.println(divide(-2, 0));
		 System.out.println(divide(2147483647, 2));
		 System.out.println(divide(2, 2147483647));
		 System.out.println(divide(2147483647, 2147483647));
	
		System.out.println(divide(1100540749, -1090366779));
		
		System.out.println(divide(-2147483648, -2));
		 
	 }
}
