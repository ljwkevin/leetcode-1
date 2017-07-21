package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月11日
 * @Description
 * 题目介绍：https://leetcode.com/problems/word-break-ii/  <br/>
 * 解题思路：先判断是否能到达，不能就考虑了。
 */
public class WordBreakII {
	 public boolean isWordBreak(String s, Set<String> wordDict) {
		 if(s.length()==0)
			 return true;
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
	 
	 public List<String> wordBreak(String s, Set<String> wordDict) {
		 	 if(!isWordBreak(s, wordDict))
		 		 return new LinkedList<>(); 
		  	 boolean[] isArrived = new boolean[s.length()];
		  	 List<String>[] ls = new List[s.length()];
		  	 
		  	 Set<Integer> lenSet = new HashSet<>();
		  	 for(String str :wordDict)
		  		  lenSet.add(str.length());
		  	 
		 	 for(int i =0;i<s.length();++i){
		 		 for(Integer len :lenSet){
		 			 int j = i-len+1;
		 			 if(j<0)
		 				 break;
		 			 j = j-1;
		 			 if(j!=-1)
		    			 if(!isArrived[j])
		    				 continue;
		 			 String str0 = s.substring(j+1, i+1);
		 			 if(wordDict.contains(str0)){ 
		 				isArrived[i]=true;
		 				if(ls[i]==null)
		    				ls[i] = new LinkedList<>();
		 				if(j==-1){
		    				ls[i].add(str0);
		    			}else{
		    				for(String str :ls[j])
		    					ls[i].add(str+" "+str0);
		    			}
		 			 }
		 		 }
		 	 }
		    		
	   
	        return ls[s.length()-1];
	 }
	 
	 
	 @Test
	 public void main(){
		 String s = "catsanddog";
		 Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		 
		 for(String str :wordBreak(s, wordDict))
			 System.out.println(str);
	
	 }
}
