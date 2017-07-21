package Stack;

import java.util.Stack;
import org.junit.Test;

/** 
 * @author 闵大为
 * @date 2015年6月27日
 * @Description
 * 解题思路：
 * <li>利用和为0来配对，但注意先正后负
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
