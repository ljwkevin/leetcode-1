package String;

/**
 * @author �ɴ�Ϊ
 * @date 2015��8��1��
 * @Description
 * ��Ŀ�ο���https://leetcode.com/problems/longest-common-prefix/
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
