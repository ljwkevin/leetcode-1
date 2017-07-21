package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月23日
 * @Description
 * 题目描述：<br/>
 * Given an array of strings, return all 
 * groups of strings that are anagrams.<br/>
 * <br/>
 * 解题思路：<br/>
 * 排序后用HashMap存储记录.<br/>
 */
public class Anagrams {
	
	 String sortStr(String str){
		 char[] chs = str.toCharArray();
		 Arrays.sort(chs);
		 return new String(chs);
	 }
	
	 public List<String> anagrams(String[] strs) {
		 
		 Map<String,List<String>> maps = new HashMap<>();
		 for(String str:strs){
			 String s = sortStr(str);
			 if(!maps.containsKey(s)){
				 List<String> ls = new ArrayList<String>();
				 maps.put(s, ls);
			 }
			 maps.get(s).add(str);
		 }
		 
		 List<String> rtLs = new ArrayList<String>();
		 for(List<String> ls : maps.values()){
			 if(ls.size()>1){
				 for(String aString : ls)
					 rtLs.add(aString);
			 }
		 }
		 return rtLs;
	 }
	 
	 
	 @Test
	 public void main(){
		 String[] strs = {"tea","and","ate","eat","dan"};
		 List<String> ls = anagrams(strs);
		 for(String str :ls)
		 	 System.out.println(str);
		  
	 }
}
