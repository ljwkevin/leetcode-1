package String;
/**
 * @author 闵大为
 * @date 2015年7月27日
 * @Description
 * 可参考KMP算法： https://leetcode.com/discuss/47503/ac-clean-java-kmp-solution <br/>
 */
public class ImplementStrStr {
	 public int strStr(String haystack, String needle) {
		 if(haystack==null||needle==null)
			 return -1;
		 int len = needle.length();
		 for(int i=0;i+len<=haystack.length();++i){
			 if(haystack.substring(i, i+len).endsWith(needle))
				 return i;
		 }
		 return -1;
	 }
}
