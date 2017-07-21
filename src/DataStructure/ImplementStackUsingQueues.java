package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 参考：https://leetcode.com/discuss/45619/accepted-java-solution
 */
public class ImplementStackUsingQueues {
	class MyStack {
		
		Queue<Integer> queue = new LinkedList<>();
		
	    // Push element x onto stack.
	    public void push(int x) {
	        queue.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	    	Queue<Integer> q2 = new LinkedList<>();
	    	int x =queue.poll();
	    	while(!queue.isEmpty()){
	    		q2.add(x);
	    		x = queue.poll();
	    	}
	    	queue = q2;
	    	q2 = null;
	    }

	    // Get the top element.
	    public int top() {
	    	Queue<Integer> q2 = new LinkedList<>();
	    	int x =queue.poll();
	    	while(!queue.isEmpty()){
	    		q2.add(x);
	    		x = queue.poll();
	    	}
	    	q2.add(x);
	    	
	    	queue = q2;
	    	q2 = null;
	    	return x;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
	
	@Test
	public void main(){
		 MyStack mStack = new MyStack();
		 mStack.push(1);
		 //System.out.println(mStack.top());
		 mStack.push(2);
		// System.out.println(mStack.top());
		 mStack.push(3);
		// System.out.println(mStack.top());
	
		 mStack.pop();
		 
		 for(int i :mStack.queue)
			 System.out.print(i+" ");
		 System.out.println();
		 
		 mStack.pop();
		 
		 for(int i :mStack.queue)
			 System.out.print(i+" ");
		 System.out.println();
		 
		 mStack.pop();
		 
		 for(int i :mStack.queue)
			 System.out.println(i+" ");
		 
		 System.out.println(mStack.empty());
		 
		 
	}
}
