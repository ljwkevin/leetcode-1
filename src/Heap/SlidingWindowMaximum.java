package Heap;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 求解窗口内的最大值,经典算法，参考（push好像有点问题）：
 * https://leetcode.com/discuss/47139/this-is-a-typical-monotonic-queue-problem
 * <br/>
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length==0||k==0)
    		return new int[0];
        int len = nums.length-k+1;
    	int[] result = new int[len];
    	Deque<Integer> deque = new LinkedList<>();
    	int max = Integer.MIN_VALUE;
    	int num = 0;
    	for(int i =0;i<k;++i){
    		deque.addLast(nums[i]);
    		if(nums[i]>max){
    			max = nums[i];
    			num = 1;
    		}else if(nums[i]==max){
    			num++;
    		}
    	}
    	result[0] = max;
    	for(int i = k;i<nums.length;++i){
    		int pre = nums[i-k];
    		int now = nums[i];
    		if(pre==result[i-k]);{
    			num--;
    			if(num==0){
    				max =Integer.MIN_VALUE;
    			}
    		}
    		deque.removeFirst();
    		deque.addLast(now);
    		if(num>0){
    			if(now>max){
    				max = now;
    				num =1;
    				result[i-k+1]=now;
    			}else if(now==max){
    				num ++;
    				result[i-k+1]=now;
    			}else{
    				result[i-k+1]=max;
    			}
    		}else{
    			Iterator<Integer> it =deque.iterator();
    			while(it.hasNext()){
    				int val = it.next();
    				if(val>max){
    	    			max = val;
    	    			num = 1;
    	    		}else if(val==max){
    	    			num++;
    	    		}
    			}
    			result[i-k+1]=max;
    		}
    	}
    	return result;
    }
    
    @Test
    public void main(){
    	int[] nums = {1,3,13,-3,5,3,6,7};
    	int k =3;
    	int[] answers = maxSlidingWindow(nums, k);
    	for(int ans :answers){
    		System.out.print(ans+" ");
    	}
    	System.out.println();
    }
    
}
