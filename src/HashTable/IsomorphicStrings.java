package HashTable;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月21日
 * @Description
 * 判断同构：建立一对一映射.<br/>
 */
public class IsomorphicStrings {
	
	/*String getStruct(String str){
		 String bg = "a";
		 Map<String,String> maps = new HashMap<>();
		 for(int i=0;i<str.length();++i){
			 String s = ""+str.charAt(i);
			 if(!maps.containsKey(s)){
				 maps.put(s, bg);
				 bg=""+(char)(bg.charAt(0)+1);
			 }
		 }
		 String rtStr = "";
		 for(int i=0;i<str.length();++i){
			 String s = ""+str.charAt(i);
			 rtStr+=maps.get(s);
		 }
		 return rtStr;
	 }*/
	
	  public boolean isIsomorphic(String s, String t) {
		  Map<String,String> map_s2t = new HashMap<>();
		  Map<String,String> map_t2s = new HashMap<>();
		  
		  for(int i=0;i<s.length();++i){
			  String s1 = ""+s.charAt(i);
			  String t1 = ""+t.charAt(i);
			  // s1->t1  
			  if(!map_s2t.containsKey(s1))
				  map_s2t.put(s1, t1);
			  else{
				  if(!map_s2t.get(s1).equals(t1))
					  return false;
			  }
			  // t1->s1
			  if(!map_t2s.containsKey(t1))
				  map_t2s.put(t1, s1);
			  else{
				  if(!map_t2s.get(t1).equals(s1))
					  return false;
			  }
		  }
		  
		  return true;
	  }
	  
	  @Test
	  public void main(){
		  String[][] tests ={
				  {"egg", "add"},
				  {"foo", "bar"},
				  {"paper", "title"}
		  };
		  for(int i=0;i<tests.length;++i){
			System.out.println(isIsomorphic(tests[i][0],tests[i][1]));
		  }
	  }
}
