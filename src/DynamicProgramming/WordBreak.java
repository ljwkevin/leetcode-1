package DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author �ɴ�Ϊ
 * @date 2015��8��10��
 * @Description
 * ��Ŀ������https://leetcode.com/problems/word-break/ <br/>
 * ����˼·��ת��Ϊ��¥�ݣ�ÿ���߼����������̨���ܷ��ߵ���
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
