package Stack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * TODO(这里用一句话描述这个类的作用)
 */
public class BasicCalculator {
	
	
    public int calculate(String s) {
    	Stack<Integer> stack = new Stack<>();
    	for(int i =0;i<s.length();++i){
    		int j = i;
    		while(j<s.length()&&Character.isDigit(s.charAt(j)))
    			j++;
    		if(j>i){
    			stack.push(Integer.parseInt(s.substring(i,j)));
    			i = j-1;
    			continue;
    		}
    		
    		if(s.charAt(i)=='+')
    			stack.push(-1);
    		else if(s.charAt(i)=='-')
    			stack.push(-2);
    		else if(s.charAt(i)=='(')
    			stack.push(-3);    	    					
    		else if(s.charAt(i)==')'){
    			int num = 0;
    			while(true){
    				int num1 = stack.pop();
    				int zf = stack.pop();
    				if(zf==-1)
    					num+=num1;
    				else if(zf==-2)
    					num-=num1;
    				else{
    					num+=num1;
    					stack.push(num);
    					break;
    				}
    			}
    		}else
    			continue;
    	}
    	
    	int num = 0;
    	while(stack.size()>1){
			int num1 = stack.pop();
			int zf = stack.pop();
			if(zf==-1)
				num+=num1;
			else
				num-=num1;
		}
    	num += stack.pop();
        return num;
    }
    
    @Test
    public void main(){
    	String s1 = "11 + 1";
    	String s2 =	" 2-1 + 2 ";
    	String s3 = "(1+(4+5+2)-3)+(6+8)";
    	System.out.println(calculate(s1));
    	System.out.println(calculate(s2));
    	System.out.println(calculate(s3));
    	
    }
}
