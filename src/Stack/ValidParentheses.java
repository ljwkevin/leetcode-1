package Stack;

import java.util.Stack;
import org.junit.Test;

/** 
 * @author �ɴ�Ϊ
 * @date 2015��6��27��
 * @Description
 * ����˼·��
 * <li>���ú�Ϊ0����ԣ���ע��������
 */
public class ValidParentheses {
	
	public Integer char2Integer(char ch){
		if(ch=='(')
			return 1;
		else if(ch==')')
			return -1;
		else if(ch=='{')
			return 2;
		else if(ch=='}')
			return -2;
		else if(ch=='[')
			return 3;
		else
			return -3;
	}
	
	public boolean isValid(String s){
		Stack<Integer> stack = new Stack();
		for(int i=0;i<s.length();++i){
			Integer nowInt = char2Integer(s.charAt(i));
			if(stack.size()==0||(stack.peek()+nowInt)!=0){
				stack.push(nowInt);
			}else{
				if(nowInt<0)
					stack.pop();
				else
					return false;
			}
		}
		return stack.size()==0;
	}
	
	@Test
	public void main(){
		String str = "((){}[]){}";
		System.out.println(isValid(str));
	}
	
}
