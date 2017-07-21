package DataStructure;

import java.util.Stack;
/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 题目：https://leetcode.com/problems/min-stack/ <br/>
 * 解题思路： 再用另一个栈来记录最小值. <br/>
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
