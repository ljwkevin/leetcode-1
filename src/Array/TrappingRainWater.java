package Array;

import org.junit.Test;

/**
 * @ClassName: TrappingRainWater 
 * @author 闵大为
 * @date 2015年6月22日
 * @solvingIdeas
 * <li>1 知道左边和右边最大的数
 * <li>2 根据短板原理修正左右最大的数
 * <li>3 与当前值进行比较，再次修正 
 * <li>4 注意全为空的情况
 * 
 * 简单高效算法：寻找第二高的
 * int trap(int A[], int n) {
		int secHight = 0;
		int left = 0;
		int right = n-1;
		int area = 0;
		while (left < right){
			if (A[left] < A[right]){
				secHight = max(A[left], secHight);
				area += secHight-A[left];//计算当前格的能装雨水的容量
				left++;
			} else {
				secHight = max(A[right], secHight);
				area += secHight-A[right];
				right--;
			}
		}
		return area;
	}
 * 
 * 
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int left = 0;
		int right = height.length-1;
		int sum = 0;
		int secHeight = 0;
		while(left<right){
			if(height[left]<height[right]){
				secHeight = Math.max(height[left], secHeight);
				sum+=secHeight-height[left];
				left++;
			}else{
				secHeight = Math.max(height[right], secHeight);
				sum+=secHeight-height[right];
				right--;
			}
		}
		return sum;
	}
	
	public int trap2(int[] height) {
		if(height.length==0)
			return 0;
		
		int[] leftMax = new int[height.length];
		int[] leftIdx = new int[height.length];
		int[] rightMax = new int[height.length];
		int[] rightIdx = new int[height.length];

		// to ensure leftMax and leftIdx
		leftMax[0]=height[0];
		leftIdx[0]=0;
		for(int i=1;i<height.length;++i){
			if(leftMax[i-1]>height[i-1]){ 
				leftMax[i]=leftMax[i-1];
				leftIdx[i]=leftIdx[i-1];
			}else{
				leftMax[i]=height[i-1];
				leftIdx[i]=i-1;
			}
		}
		
		// to ensure rightMax and rightIdx
		rightMax[height.length-1]=height[height.length-1];
		rightIdx[height.length-1]=height.length-1;
		for(int i=height.length-2;i>=0;--i){
			if(rightMax[i+1]>height[i+1]){ 
				rightMax[i]=rightMax[i+1];
				rightIdx[i]=rightIdx[i+1];
			}else{
				rightMax[i]=height[i+1];
				rightIdx[i]=i+1;
			}
		}
	
		/**System.out.println("leftMax[i] leftIdx[i] rightMax[i] rightIdx[i]");
		for(int i=0;i<height.length;++i){
			System.out.println("idx:"+i+" "+leftMax[i]+"　"+leftIdx[i]+" "+rightMax[i]+" "+rightIdx[i]);
		}*/
		
		int sum = 0;
		for (int idx = 1; idx < height.length - 1; ++idx) {

			int lfIdx = leftIdx[idx];
			int rgIdx = rightIdx[idx];

			if (leftMax[idx] > rightMax[idx]) {
				lfIdx = idx;
				for (int i = idx - 1; i >= 0; --i) {
					if (i < leftIdx[idx]) // over range
						break;
					if (height[i] >= rightMax[idx]) {
						lfIdx = i;
						break;
					}	
				}
			} else if (leftMax[idx] < rightMax[idx]) {
				rgIdx = idx;
				for (int i = idx + 1; i <= height.length; ++i) {
					if (i > rightIdx[idx]) // over range
						break;
					if (height[i] >= leftMax[idx]) {
						rgIdx = i;
						break;
					}
				}
			}
			
			if(height[idx]>=height[lfIdx])
				lfIdx=idx;
			if(height[idx]>=height[rgIdx])
				rgIdx=idx;
				
			int targetHeight = Math.min(height[lfIdx], height[rgIdx]);
			
			for(int i=lfIdx+1;i<rgIdx;++i){
				sum+=targetHeight-height[i];
			}
			if(rgIdx-lfIdx>1)
				idx=rgIdx;
		}
		
	    return sum;    
	}
	
	@Test
	public void main(){
		int[] height ={2,1,2,1}; // 6
		System.out.println(trap(height));
	}
}
