package String;

import org.junit.Test;

/**
 * @author �ɴ�Ϊ
 * @date 2015��7��27��
 * @Description
 * �жϻ��ģ����Բο��� https://leetcode.com/discuss/44882/7-lines-12ms-easy-c-solution <br/>
 */
public class ValidPalindrome {
	  public boolean isPalindrome(String s) {
		  StringBuffer buffer = new StringBuffer();
		  for(int i=0;i<s.length();++i){
			  char ch = s.charAt(i);
			  if((ch >='a'&&ch<='z')||(ch >='0'&&ch<='9'))
				  buffer.append(ch);
			  else if(ch >='A'&&ch<='Z')
				  buffer.append((char)(ch-'A'+'a'));
		  }
		  String str1 = buffer.toString();
		  String str2 = buffer.reverse().toString();
		  return str1.endsWith(str2);   
	  }
	  
	  @Test
	  public void main(){
		  String s1 = "A man, a plan, a canal: Panama";
		  System.out.println(isPalindrome(s1));
		  
		  String s2 = "race a car";
		  System.out.println(isPalindrome(s2));
		  
	  }
}
