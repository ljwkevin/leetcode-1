package Array;
import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月1日
 * @Description
 * 解题思路：
 * 对于每一个数，计算之前和之后的个数只差diff，如果（m+n）为奇数，
 * 则寻找diff=0的数，否则寻找diff=1和diff=-1的数。
 * <b>时间复杂度并不是O(log(m+n))</b>
 */
public class MedianOfTwoSortedArrays {
	 class Node{
		int index = -1;
		int frontNum;
		int backNum;
		Node(){}
		@Override
		public String toString() {
			return "Node [frontNum=" + frontNum + ", backNum=" + backNum + "]";
		}
	 }
	 public Node calPos(int[] nums,int target){
		 int lf = 0;
		 int rg =nums.length-1;
		 Node node = new Node();
		 while(lf<=rg){
			int mid = (lf+rg)>>1;
		 	if(nums[mid]==target){
		 		node.frontNum = mid;
		 		node.backNum = nums.length-1-mid;
		 		node.index = mid;
		 		return node;
		 	}else if(nums[mid]<target){	
		 		lf=mid+1;
		 	}else{
		 		rg=mid-1;
		 	}
		 }
		 node.frontNum = lf -0 ;
		 node.backNum = nums.length-1-rg;
		 return node;
	 }
	 
	 public int findPosInNums(int[] src,int[] other,int target){
		 int lf = 0;
		 int rg = src.length-1;
		 while(lf<=rg){
			 int mid = (lf+rg)>>1;
		 	 int frontNum = mid;
	 	     int backNum =	src.length-1-mid; 
	 	     Node node = calPos(other,src[mid]);
	 	     
	 	     int t_frontNum = frontNum + node.frontNum;
	 	     int t_backNum = backNum + node.backNum;
	 	     int diff = t_frontNum - t_backNum;
	 	     
	 	     if(diff==target)
	 	 	    return mid;
	 	     
	 	     if(node.index!=-1){	 
	 	    	// equal can be one range
	 	    	if(diff==target||diff+1==target||diff-1==target)
 	    			return mid;
	 	    	
	 	    	int idx = node.index-1;
	 	    	int t_diff = diff;
	 	    	while(idx>=0&&other[idx]==src[mid]){
	 	    		t_diff -= 2;
	 	    		if(t_diff==target||t_diff+1==target||t_diff-1==target)
	 	    			return mid;
	 	    		idx--;
	 	    	 }
	 	    	 
	 	    	 idx = node.index+1;
	 	    	 t_diff = diff;
	 	    	 while(idx<other.length&&other[idx]==src[mid]){
	 	    		t_diff += 2;
	 	    		if(t_diff==target||t_diff+1==target||t_diff-1==target)
	 	    			return mid;
	 	    		idx++;
	 	    	 }
	 	     }
	 	     
	 	 	 if(diff<0)
	 	 	    lf = mid +1;
	 	 	 else
	 	 	    rg = mid-1;
		 }
		 return -1;
	 }
	 
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int totalNum = nums1.length+nums2.length;
		 boolean isSingle = (totalNum%2==1);
		 if(isSingle){
			int pos = findPosInNums(nums1,nums2,0); 
			if(pos!=-1)
				return nums1[pos];
			pos = findPosInNums(nums2,nums1,0);
			if(pos!=-1)
				return nums2[pos];
		 }else{
			 int v1=-1,v2=-1;
			 int pos = findPosInNums(nums1,nums2,1); 
			 if(pos!=-1){
				v1 = nums1[pos];
			 }else{
				 pos = findPosInNums(nums2,nums1,1);
				 v1= nums2[pos];
			 }
			 
			 pos = findPosInNums(nums1,nums2,-1); 
			 if(pos!=-1){
				v2 = nums1[pos];
			 }else{
				 pos = findPosInNums(nums2,nums1,-1);
				 v2= nums2[pos];
			 }
			 return (v1+v2)*1.0/2;	
		 }
		 return -1;
	 }
	 
	 @Test
	 public void main(){
		 int[] nums1 ={2,3,4};
		 int[] nums2 ={3};
		 System.out.println(findMedianSortedArrays(nums1,nums2));
		  //System.out.println(findPosInNums(nums1,nums2,1));
		  //System.out.println(calPos(nums2,1));
	 }
}
