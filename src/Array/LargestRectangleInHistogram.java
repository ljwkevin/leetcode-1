package Array;

import java.util.Stack;

import org.junit.Test;

/**
 * @author �ɴ�Ϊ
 * @date 2015��7��14��
 * @description
 * ��Ŀ������</br>
 * Given n non-negative integers representing the 
 * histogram's bar height where the width of each 
 * bar is 1, find the area of largest rectangle 
 * in the histogram.</br>
 * </br>
 * ����˼·��</br>
 * ���ö�ջ���������</br>
 */
public class LargestRectangleInHistogram {
	 public int largestRectangleArea(int[] height) {
		if(height.length==0)
			return 0;
		 Stack<Integer> stack = new Stack<>();
		 int maxArea = 0;
		 int i=0;
		 int length = height.length;
		 while(i<length){
			 if(stack.isEmpty()||height[i]>=height[stack.peek()]){
				 stack.push(i++);
			 }else{
				 int j = stack.pop();
				 int area = height[j]*(stack.isEmpty()?i:i-stack.peek()-1);
				 maxArea = area>maxArea?area:maxArea; 
			 }
		 }	 
		 while(!stack.isEmpty()){
			 int j = stack.pop();
			 int area = height[j]*(stack.isEmpty()?i:i-stack.peek()-1);
			 maxArea = area>maxArea?area:maxArea; 
		 }
	    return maxArea;
	 }
	 
	 @Test
	 public void main(){
		 int[] height = {2,1,5,6,2,3};
		 int[] height2 = {1};
		 System.out.println(largestRectangleArea(height));
		 System.out.println(largestRectangleArea(height2));
	 }
}
