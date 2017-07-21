package Array;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月13日
 * @Description
 * 题目描述：</br>
 * Given an unsorted array of integers,find the length
 * of the longest consecutive elements sequence.</br>
 * </br>
 * 解题思路：</br>
 * 1. 我使用数组和结构来记录区域，遍历查询，然后进行维护。</br>
 * 2. 网上查找，发现使用Map比较好，然后找到数字左边的或者右边的数字。</br>
 */
public class LongestConsecutiveSequence {
	class Node{
		int bg;
		int ed;
		public Node(int bg, int ed) {
			this.bg = bg;
			this.ed = ed;
		}
		@Override
		public String toString() {
			return "Node [bg=" + bg + ", ed=" + ed + "]";
		}
	}
	public int longestConsecutive(int[] nums) {
		if(nums.length==0)
			return 0;
		List<Node> lsNode = new LinkedList<>();
		lsNode.add(new Node(nums[0],nums[0]));
		for(int i=1;i<nums.length;++i){
			boolean isIn =false;
			Node node1 = null;
			Node node2 = null;
			for(Node node :lsNode){
				if(node.bg<=nums[i]&&nums[i]<=node.ed){
					isIn = true;
					break;
				}
				if(node.bg-1==nums[i]||node.ed+1==nums[i]){
					if(node1==null)
						node1 = node;
					else if(node2==null){
						node2 = node;
						break;
					}	
				}
			}
		
			if(node1!=null){
				if(node2==null){
					lsNode.add(new Node(Math.min(node1.bg,nums[i])
							,Math.max(node1.ed,nums[i])));
					lsNode.remove(node1);
				}else{
					lsNode.add(new Node(
							Math.min(node2.bg,Math.min(node1.bg,nums[i])),
							Math.max(node2.ed,Math.max(node1.ed,nums[i])))
					);
					lsNode.remove(node1);
					lsNode.remove(node2);
				}
			}else{
				if(!isIn){
					lsNode.add(new Node(nums[i],nums[i]));
				}
				
			}
		}
        int maxLength = 0;
        for(Node node :lsNode){
        	if(node.ed-node.bg+1>maxLength)
        		maxLength = node.ed-node.bg+1;
        }
        return maxLength;
    }
	
	@Test
	public void main(){
		int nums[] = {-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
		System.out.println(longestConsecutive(nums));
	}
}
