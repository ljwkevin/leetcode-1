package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 用Stack模拟Queue.<br/>
 */
public class ImplementQueueUsingStacks {
	class MyQueue {
		
		Stack<Integer> stack = new Stack<Integer>();
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	        stack.add(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	    	Stack<Integer> stack2 = new Stack<Integer>();
	    	int x = stack.pop();
	    	while(!stack.isEmpty()){
	    		stack2.push(x);
	    		x = stack.pop();
	    	}
	    	while(!stack2.isEmpty()){
	    		stack.push(stack2.pop());
	    	}
	    }

	    // Get the front element.
	    public int peek() {
	    	Stack<Integer> stack2 = new Stack<Integer>();
	    	int x = stack.pop();
	    	while(!stack.isEmpty()){
	    		stack2.push(x);
	    		x = stack.pop();
	    	}
	    	stack2.push(x);
	    	while(!stack2.isEmpty()){
	    		stack.push(stack2.pop());
	    	}
	    	return x;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return this.stack.isEmpty();
	    }
	}
	
	@Test	
	public void main(){
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(3);
		myQueue.push(5);
		while(!myQueue.empty()){
			System.out.println(myQueue.peek());
			myQueue.pop();
		}
	}
}
