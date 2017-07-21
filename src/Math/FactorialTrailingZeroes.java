package Math;

import org.junit.Test;
/**
 * @author �ɴ�Ϊ
 * @date 2015��8��8��
 * @Description
 * ��Ŀ�ο���https://leetcode.com/problems/factorial-trailing-zeroes/ <br/>
 * ����ο���https://leetcode.com/discuss/36157/java-solution-with-only-2-lines
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
