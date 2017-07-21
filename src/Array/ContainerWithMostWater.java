package Array;

import org.junit.Test;
import static org.junit.Assert.*;
/** 
 * @author 闵大为 
 * @date 2015年7月18日
 * @Descriptionian
 * 题目描述:</br>
 * 寻找两条线使得盛放的容积最大</br>
 * </br>
 * 解题思虑:</br>
 * 1 两两组合，此外遍历时可以提前停止</br>
 * 2 参考 http://www.cnblogs.com/codingmylife/archive/2012/09/05/2671548.html </br>
 */
public class ContainerWithMostWater {
	 public int maxArea2(int[] height) {
		 int[] lmax = new int[height.length]; // 下标
		 int[] rmax = new int[height.length];  
 		 lmax[0]=0;
		 for(int i=1;i<height.length;++i){
			if(height[i]>height[lmax[i-1]])
				lmax[i]=i;
			else
				lmax[i]=lmax[i-1];
		 }
		 rmax[height.length-1]=height.length-1;
		 for(int i=height.length-2;i>=0;--i){
			if(height[i]>height[rmax[i+1]])
				rmax[i]=i;
			else
				rmax[i]=rmax[i+1];
		 }
		 
		 int maxArea = 0;
		 
		 for(int i=0;i<=height.length-1;++i){
			 int bg=lmax[i];;
			 int ed=rmax[i];;
			 int h=height[ed];
			 if(height[bg]>height[ed]){
				 h=height[ed];
				for(int j=i-1;j>=bg;--j){
					if(height[j]>height[ed]){
						bg=j;
						break;
					}
				}
			 }else if(height[bg]<height[ed]){
				 h=height[bg];
				 for(int j=i+1;j<=ed;++j){
					if(height[j]>height[bg]){
						ed=j;
						break;
					}
				}
			 }
			 
			 int area = (ed-bg)*h;
			 if(area>maxArea)
				 maxArea=area;
		 }
		 return maxArea;
	 }
	 
	 public int maxArea(int[] height) {
		 if(height.length<2)
			 return 0;
		 int maxArea = 0;
		 int maxNum = -1;
		 for(int i=0;i<height.length-1;++i){
			 if(height[i]<maxNum)
				 continue;
			 maxNum = height[i];
			 for(int j=height.length-1;j>=i+1;--j){
				 int h = Math.min(height[i],height[j]);
				 int area = h*(j-i);
				 if(area>maxArea)
					 maxArea = area;
				 if(h==height[i])
					 break;
			 }
		 }
		 return maxArea;
	 }
	 @Test
	 public void main(){
		 //int[] height ={1,1};
		 int[] height ={0,4,5,2,4,1,2,3};
		 assertEquals(18, maxArea(height));
		 System.out.println("OK!");
	 }
}
