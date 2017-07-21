package Math;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月8日
 * @Description
 * 题目参考：https://leetcode.com/problems/factorial-trailing-zeroes/ <br/>
 * 解题参考：https://leetcode.com/discuss/36157/java-solution-with-only-2-lines
 */
public class FactorialTrailingZeroes {
	 public int trailingZeroes(int n) {
		 int gs = 0;
		 int i =1;
		 while(i<=n/5){
			 i*=5;
			 gs+=n/i;
		 }
		 return gs;
	 }
	 
	 @Test
	 public void main(){
		 System.out.println(trailingZeroes(Integer.MAX_VALUE));
	 }
}
