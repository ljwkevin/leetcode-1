package String;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月31日
 * @Description
 * 题目参考：https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
	 public int myAtoi(String str) {
		    if(str.length()==0)
			  return 0;
	        int gs = 0;
	        int sum =0;
	        boolean hasSign = false;
	        boolean isDigit =false;
	        for(int i=0;i<str.length();++i){
	        	if(str.charAt(i)=='-'||str.charAt(i)=='+'){
	        		if(hasSign)
	        			return 0;
	   	        	hasSign = true;
	        		if(str.charAt(i)=='-')
	   	        		gs--;
	   	        	else
	   	        		gs++;
	   	        	continue;
	   	        }
	        	if(str.charAt(i)==' '){
	        		if(isDigit||hasSign)
	        			break;
	        		continue;
	        	}
	        	if(!Character.isDigit(str.charAt(i)))
	        		break;
	        
	        	if(sum>214748364||(sum == 214748364&&str.charAt(i)-'0'>7)){
	        		if(hasSign){
	        			if(gs==0)
	        				return 0;
	        			else if(gs>0)
	        				return Integer.MAX_VALUE;
	        			else
	        				return Integer.MIN_VALUE;
	        		}else{
	        			return Integer.MAX_VALUE;
	        		}
	        	}
	        	sum=sum*10+(str.charAt(i)-'0');
	        	
	        	isDigit =true;
	        }
	        if(!hasSign)
	        	gs =1;
	        return gs*sum;
	        	
	 }
	 
	 @Test
	 public void main(){
		System.out.println(Integer.MAX_VALUE==myAtoi(""+Integer.MAX_VALUE));
		System.out.println(Integer.MIN_VALUE==myAtoi(""+Integer.MIN_VALUE));
		System.out.println(1014==myAtoi("1014"));
		System.out.println(0==myAtoi("   +0 123"));
		System.out.println(0==myAtoi("+-2"));
		System.out.println(10==myAtoi("    010"));
		System.out.println(-12==myAtoi("  -0012a42"));
		System.out.println(0==myAtoi("   - 321"));
		System.out.println(0==myAtoi(" ++1"));
		System.out.println(myAtoi("2147483648"));
	 }
}
