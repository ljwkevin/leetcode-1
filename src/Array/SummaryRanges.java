package Array;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
/** 
 * @author 闵大为
 * @date 2015年6月27日
 * @Description
 * 解题思路：
 * <li>直接遍历即可
 */

public class SummaryRanges {
	public String ints2String(int iStart,int iEnd){
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(iStart);
		if(iStart!=iEnd){
			strBuff.append("->");
			strBuff.append(iEnd);		
		}
		return strBuff.toString();
	}
	
	public List<String> summaryRanges(int[] nums){
		List<String> ls = new ArrayList<>();
		if(nums.length==0)
			return ls;
		int iStart=nums[0],iEnd=nums[0];
		for(int i=1;i<nums.length;++i){
			if(nums[i]==iEnd+1){
				iEnd++;
			}else{
				ls.add(ints2String(iStart, iEnd));
				iStart=iEnd=nums[i];
			}
		}
		ls.add(ints2String(iStart, iEnd));
		return ls;
	}
	
	@Test
	public void main(){
		int[] nums = {0,1,2,4,5,7};
		int[] nums2 = {1,2,3,4,5,6,7};
		List<String> strs = summaryRanges(nums2);
		strs.forEach(e->{System.out.println(e);});
	}
}
