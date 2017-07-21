package String;

/**
 * @author 闵大为
 * @date 2015年8月1日
 * @Description
 * 题目参考：https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
		 if(strs.length==0)
	        return ""; 
		 String rtStr = strs[0];
		 for(int i=0;i<rtStr.length();++i){
			 for(int j =1;j<strs.length;++j){
				 if(i>=strs[j].length()||rtStr.charAt(i)!=strs[j].charAt(i)){
					 return rtStr.substring(0,i);
				 }
			 }
		 }
		 return rtStr;
	 }
}
