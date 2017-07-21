package Array;
import org.junit.Test;
/**
 * @ClassName: SortColors 
 * @Description: ��ɫ����
 * @author �ɴ�Ϊ
 * @date 2015��6��17��
 */
/*
//ƽ�Ʋ��룬Ư���Ľⷨ
class Solution {
public:
    void sortColors(int A[], int n) {
        int i = -1;
        int j = -1;
        int k = -1;
        for(int p = 0; p < n; p ++)
        {
            //���ݵ�i�����֣�Ų��0~i-1����
            if(A[p] == 0)
            {
                A[++k] = 2;    //2����Ų
                A[++j] = 1;    //1����Ų
                A[++i] = 0;    //0����Ų
            }
            else if(A[p] == 1)
            {
                A[++k] = 2;
                A[++j] = 1;
            }
            else
                A[++k] = 2;
        }

    }
};
 */
public class SortColors {
	public void sortColors(int[] nums) {
        int index0 = 0;
        int index2 = nums.length-1;
    	while(nums[index0]==0){
			index0++;
			if(index0>=nums.length)
				return;
    	}
		while(nums[index2]==2){
			index2--;
			if(index2<0)
				return;
		}
		int index = index0;
		while(index0<=index2&&index<=index2){
            if(nums[index]==0){
            	if(index==index0){
            		index++;
            		index0++;
            	}else{
            	 nums[index] = nums[index0];
            	 nums[index0] = 0;
            	 while(nums[index0]==0)
        			 index0++;
            	}
			}else if(nums[index]==2){
			 	 nums[index] = nums[index2];
             	 nums[index2] = 2;
            	 while(nums[index2]==2)
        			 index2--;
			}else{
				index++;
			}
		}
    }
	
	@Test
	public void main(){
		int nums[] ={2,1,0};
		//printIntArray(nums);
		sortColors(nums);
		printIntArray(nums);
	}
	
	void printIntArray(int arrays[]){
		for(int i:arrays)
			System.out.printf(i+" ");
		System.out.println();
	}
}