package Math;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 可以参考：https://leetcode.com/discuss/47567/simple-java-solution-with-explanation-use-binary-search
 */
public class Pow_x_n {
	 double pow(double x, int n){
		 if(n==1)
			 return x;
		 int n1 = n/2;
		 int n2 = n-n1;
		 double v1 = pow(x,n1);
		 if(n2>n1)
			 return v1*v1*x;
		 else
			 return v1*v1;
	 }
	
	 public double myPow(double x, int n) {
		 if(n==0)
			 return 1;
		 else{ 
			 if(x==1)
				 return 1;
			 if(x==-1)
				return n%2==0?1:-1;	 
			 
			 if(n>0)
				 return pow(x,n);
	         else
	        	 return 1/pow(x,-n);
		 }
	 }
	 
	 @Test
	 public void main(){
		 System.out.println(myPow(1,3));
	 }
	 
}
