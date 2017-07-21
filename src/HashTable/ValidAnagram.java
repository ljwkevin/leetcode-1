package HashTable;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年8月5日
 * @Description
 * 题目参考：https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
	 public boolean isAnagram(String s, String t) {
		 	if(s==null||t==null){
		 		if(s==null&&t==null)
		 			return true;
		 		else
		 			return false;
		 	}
		 	if(s.length()!=t.length())
		 		return false;
		 
		 	Map<Character, Integer> map = new HashMap<Character, Integer>();
		 	for(Character ch : s.toCharArray()){
		 		if(map.containsKey(ch)){
		 			map.put(ch, map.get(ch)+1);
		 		}else{
		 			map.put(ch, 1);
		 		}
		 	}
		 	
		 	for(Character ch : t.toCharArray()){
		 		if(map.containsKey(ch)){
		 			if(map.get(ch)==0)
		 				return false;
		 			else
		 				map.put(ch, map.get(ch)-1);
		 		}else
		 			return false;
		 	}
		 	
	        return true;
	 }
	 
	 @Test
	 public void main(){
		 String[][] strs ={
				 {"anagram","nagaram"},
				 { "rat","car"}
		 };
		 for(String[] str :strs)
			 System.out.println(isAnagram(str[0], str[1]));		 
	 }
}
