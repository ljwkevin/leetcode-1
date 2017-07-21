package String;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月31日
 * @Description
 * 题目参考：https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {	
	 public String convert(String s, int numRows) {
		 if(numRows==1)
			 return s;
	       String strs[] = new String[numRows];
	       for(int i =0;i<strs.length;++i)
	    	   strs[i]="";
	       int idx = -1;
	       boolean isAdd = true;
	       for(int i=0;i<s.length();++i){
	    	   if(isAdd){
	    		  idx++;
	    		  if(idx==numRows){
	    			  isAdd =false;
	    			  idx=idx-2;
	    		  }
	    	   }else{
	    		   idx--;
		    	   if(idx==-1){
		    			 isAdd =true;
		    			 idx=idx+2;
		    		}
	    	   }
	    	   strs[idx]+=s.charAt(i);
	       }
	       String rtStr ="";
	       for(String str :strs)
	    	   rtStr+=str;
	       return rtStr;
	 }
	 
	 @Test
	 public void main(){
		 String s = "PAYPALISHIRING";
		 int  numRows = 3;
		 String a = "AB";
		 System.out.println(convert("AB", 2).equals(a));
	 }
}
