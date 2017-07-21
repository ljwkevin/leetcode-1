package Stack;

import java.util.Stack;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 题目参考：https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
	
	public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<tokens.length;++i){
        	String str = tokens[i];
        	if(str.equals("+")){
        		int num2 =s.pop();
        		int num1 =s.pop();
        		s.push(num1+num2);
        	}else if(str.equals("-")){
        		int num2 =s.pop();
        		int num1 =s.pop();
        		s.push(num1-num2);
        	}else if(str.equals("*")){
        		int num2 =s.pop();
        		int num1 =s.pop();
        		s.push(num1*num2);
        	}else if(str.equals("/")){
        		int num2 =s.pop();
        		int num1 =s.pop();
        		s.push(num1/num2);
        	}else{
        		s.push(Integer.parseInt(str));
        	}
        }
        return s.pop();
    }
	
	@Test
	public void main(){
		String[] t1 = {"2", "1", "+", "3", "*"};
		String[] t2 = {"4", "13", "5", "/", "+"};
		String[] t3 = {"3","-4","+"};
		System.out.println(evalRPN(t1));
		System.out.println(evalRPN(t2));
		System.out.println(evalRPN(t3));
	}
}
