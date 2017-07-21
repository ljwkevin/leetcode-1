package Math;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年8月8日
 * @Description
 * 题目参考：https://leetcode.com/problems/add-binary/ <br/>
 * 解题参考：https://leetcode.com/discuss/47112/13-lines-easy-java-solution-simple-and-elegant
 */
public class AddBinary {
	  public String addBinary(String a, String b) {
		  String s1,s2;
		  if(a.length()>b.length()){
			  s1=a;
			  s2=b;
		  }else{
			  s1=b;
			  s2=a;
		  }
		 int len = s1.length()-s2.length();
		 int jw = 0;
		 StringBuffer buffer = new StringBuffer();
		 for(int i = s2.length()-1;i>=0;--i){
			 int i1 = s1.charAt(i+len)-'0';
			 int i2 = s2.charAt(i)-'0';
			 int sum = i1+i2+jw;
			 jw =sum/2;
			 buffer.append((char)('0'+sum%2));
		 }
		 for(int i = len-1;i>=0;--i){
			 int i1 = s1.charAt(i)-'0';
			 int sum = i1+jw;
			 jw =sum/2;
			 buffer.append((char)('0'+sum%2));
		 }
		 if(jw==1)
			 buffer.append('1');
		  return buffer.reverse().toString();
	  }
	  
	  
	  @Test
	  public void main(){
		  String a = "1";
		  String b = "1";
		  System.out.println(addBinary(a, b));
	  }
}
