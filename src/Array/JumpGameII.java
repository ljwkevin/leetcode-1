package Array;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * @author �ɴ�Ϊ
 * @date 2015��7��15��
 * @Description: 
 * ��Ŀ������</br>
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.Each element in the array represents 
 * your maximum jump length at that position.Your goal is to reach the 
 * last index in the minimum number of jumps.</br>
 * </br>
 * ����˼·��</br>
 * 1.������Զ�ľ�������</br>
 * 2.̰�Ĳο���http://blog.csdn.net/loverooney/article/details/38455475 </br>
 */

/* 
 * We use "last" to keep track of the maximum distance that has been reached 
 * by using the minimum steps "ret", whereas "curr" is the maximum distance 
 * that can be reached by using "ret+1" steps. Thus, 
 * curr = max(i+A[i]) where 0 <= i <= last. 
 */  
/*
class Solution {  
public:  
    int jump(int A[], int n) {  
        int ret = 0;//��ǰ����  
        int last = 0;//��һ���ɴ���Զ����  
        int curr = 0;//��ǰһ���ɴ���Զ��  
        for (int i = 0; i < n; ++i) {  
            //�޷���ǰ����ֱ�ӷ���  
            if(i>curr){  
                return -1;  
            }  
            //��Ҫ�����´���Ծ�������last�͵�ִ�е�����ret  
            if (i > last) {  
                last = curr;  
                ++ret;  
            }  
            //��¼��ǰ�ɴ����Զ��  
            curr = max(curr, i+A[i]);  
        }  
  
        return ret;  
    }  
*/
public class JumpGameII {
	class Node{
		int _idx;
		int _bs;
		Node(int idx,int bs){
			_idx=idx;
			_bs=bs;
		}
	}
	
	public int jump(int[] nums) {
		if(nums.length<=1)
			return 0;
		Node node0 = new Node(nums[0],1);
		Queue<Node> qNode = new LinkedList<>();
		qNode.add(node0);
		int maxPos = 0+nums[0];
		for(int i=1;i<=nums.length-1;++i){
			
			while(i>qNode.peek()._idx)
				qNode.poll();
			int i_bs=qNode.peek()._bs;
			
			int idx = i + nums[i];
			if(idx>nums.length-1)
				idx=nums.length-1;
			
			if(idx>maxPos){
				maxPos = idx;
				qNode.offer(new Node(idx,i_bs+1));
			}
			
		}
		return qNode.peek()._bs;
	}
		
	@Test
	public void main(){
		int[][] nums = {
				{1},
				{1,0},
				{2,3,1,1,4},
				{1,2,3,4,5}
		};
		int[] answers = {0,1,2,3};
		for(int i =0;i<nums.length;++i){
			if(answers[i]!=jump(nums[i])){
				System.out.println("Fail at "+i+" tip:"+jump(nums[i]));
			}
		}
		System.out.println("Test finished!");
	}
}
