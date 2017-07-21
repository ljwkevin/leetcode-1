package DataStructure;

import java.util.Stack;
/**
 * @author �ɴ�Ϊ
 * @date 2015��7��30��
 * @Description
 * ��Ŀ��https://leetcode.com/problems/min-stack/ <br/>
 * ����˼·�� ������һ��ջ����¼��Сֵ. <br/>
 */
public class MinStack {
		Stack<Integer> stack = new Stack<>();
	    Stack<Integer> min = new Stack<>();
		
	    public void push(int x) {
	        stack.push(x);
	        if(min.isEmpty()){
	        	min.push(x);
	        }else{
	        	min.push(Math.min(x, min.peek()));
	        }
	    }

	    public void pop() {
	        stack.pop();
	        min.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min.peek();
	    }
}
