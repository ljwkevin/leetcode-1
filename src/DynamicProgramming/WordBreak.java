package DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年8月10日
 * @Description
 * 题目描述：https://leetcode.com/problems/word-break/ <br/>
 * 解题思路：转换为走楼梯，每次走几步，看这个台阶能否走到。
 */
public class WordBreak {
	 public boolean wordBreak(String s, Set<String> wordDict) {
	     boolean[] isArrived = new boolean[s.length()];
		 for(int i =0;i<s.length();++i){
			 for(int j=i-1;j>=-1;--j){
	    		 if(j!=-1)
	    			 if(!isArrived[j])
	    				 continue;
				 if(wordDict.contains(s.substring(j+1, i+1))){
	    			isArrived[i]=true;
	    			break;
	    		}
	    	}
	    }
	    return isArrived[s.length()-1];
	 }
	 
	 @Test
	 public void main(){
		 
		 String s = "aaaaaaaa";
		 Set<String> wordDict = new HashSet<>(Arrays.asList("aaaa","aa"));
		 
		 System.out.println(wordBreak(s, wordDict));
	
	 }
}
