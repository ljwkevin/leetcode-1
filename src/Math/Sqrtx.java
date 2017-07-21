package Math;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 可以参考: https://leetcode.com/discuss/40604/solution-with-java
 */

public class Sqrtx {
	   public int mySqrt(int x) {
		   	int lf = 1;
		   	int rg = x;
		   	while(lf<=rg){
		   		int mid = (lf+rg)>>1;
		   		int val = x/mid;
		   		if(val==mid){
		   			if(val*val==x)
			   			return val;
		   			else 
		   				lf = mid+1;
		   		}else if(val>mid){
		   			lf =mid+1;
		   		}else{
		   			rg =mid-1;	
		   		}
		   	}
		  return rg;
	    }
	   
	   @Test
	   public void main(){
		   
		  // System.out.println(46339*46339);
		 //  System.out.println(46340*46340);
		 //  System.out.println(Integer.MAX_VALUE);
		   
		  // System.out.println((int)Math.sqrt(2147395599));
		 //  System.out.println(mySqrt(2147395599));
		   System.out.println(mySqrt(35));
		   System.out.println(mySqrt(36));
		   System.out.println(mySqrt(37));
	   }
}
