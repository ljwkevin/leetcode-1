package DynamicProgramming;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月8日
 * @Description
 * 题目参考：https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
	  public int climbStairs(int n) {
	        if(n==1)
	        	return 1;
		  	int n1 = 1;
	        int n2 = 2;
	        for(int i=3;i<=n;++i){
	        	int n3 = n1+n2;
	        	n1=n2;
	        	n2=n3;
	        }
	        return n2;
	  }
	  
	  @Test
	  public void main(){
		  System.out.println(climbStairs(3));
	  }
}
